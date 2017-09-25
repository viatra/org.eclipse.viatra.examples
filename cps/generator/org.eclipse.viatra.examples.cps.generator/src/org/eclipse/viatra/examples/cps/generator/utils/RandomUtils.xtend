/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.utils

import java.util.Collection
import java.util.List
import java.util.Random
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage
import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException

class RandomUtils {
    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param minMaxData Minimum and Maximum value (Must be greater than min.)
     * @param seed seed of the Random class
     * @return Integer between min and max, inclusive.
     * @see Random#nextInt(int)
     */
    def int randInt(MinMaxData<Integer> minMaxData, Random rand) throws ModelGeneratorException {
        if(minMaxData === null){
            throw new ModelGeneratorException("MinMaxData is null. (randInt(long seed, int min, int max))");
        }
            
        val min = minMaxData.minValue;
        val max = minMaxData.maxValue;
        
        if(min == max){
            return min;
        } 
        
        if(min > max){
            throw new ModelGeneratorException("Max must be greater then min. (randInt(MinMaxData<Integer> minMaxData = ["+minMaxData.minValue+", "+minMaxData.maxValue+"] , Random rand))");
        }
        
        return rand.nextInt((max - min) + 1) + min;
    }
    
    def int randIntOneToMax(int max, Random rand) throws ModelGeneratorException {
        return if(max <= 1) 1 else randInt(new MinMaxData<Integer>(1, max), rand);
    }
    
    def int randIntExcept(MinMaxData<Integer> minMaxData, int excepted, Random rand) throws ModelGeneratorException {
        if(minMaxData.minValue == minMaxData.maxValue){
            return minMaxData.minValue;
        }
        
        var randNumber = randInt(minMaxData, rand);
        while(randNumber == excepted){
            randNumber = randInt(minMaxData, rand);
        }
        return randNumber;  
    }
    
    def <ListElement>randElement(List<ListElement> list, Random rand) throws ModelGeneratorException {
        if(list.empty){
            throw new ModelGeneratorException("The specified list is empty. (randElement(List list, Random rand))");
        }
        
        val max = list.size-1;
        
        val randNumber = rand.nextInt((max - 0) + 1) + 0;
        
        return list.get(randNumber);
    }
    
    def randElementIndex(int size, Random rand) throws ModelGeneratorException {
        if(size == 0){
            throw new ModelGeneratorException("The specified list is empty. (randElement(List list, Random rand))");
        }
        
        val max = size-1;
        
        val randNumber = rand.nextInt((max - 0) + 1) + 0;
        
        return randNumber;
    }
    
    def <ListElement>randElementExcept(List<ListElement> list, Collection<ListElement> excepted, Random rand) throws ModelGeneratorException {
        if(excepted.containsAll(list)){
            return null;
        }
        
        if(list.size == 1){
            return list.get(0);
        }
        
        val listSize = list.size
        var randElementIndex = randElementIndex(listSize, rand);
        var randElement = list.get(randElementIndex)
        var usedIndexes = newHashSet
        while(excepted.contains(randElement)){
            usedIndexes.add(randElementIndex)
            do {
                randElementIndex = randElementIndex(listSize, rand);
            } while(usedIndexes.contains(randElementIndex))
            randElement = list.get(randElementIndex)
        }
        return randElement; 
    }
    
    def boolean randBooleanWithPercentageOfTrue(Percentage percentageOfTrue, Random rand){
        val chance = rand.nextFloat;
        return chance < percentageOfTrue.fraction;
    }

}