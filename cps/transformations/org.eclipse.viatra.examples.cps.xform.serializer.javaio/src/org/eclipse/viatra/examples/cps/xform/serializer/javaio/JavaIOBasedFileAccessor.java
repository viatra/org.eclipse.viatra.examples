/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.serializer.javaio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.Adler32;

import org.eclipse.viatra.examples.cps.xform.serializer.IFileAccessor;

import com.google.common.io.Files;

public class JavaIOBasedFileAccessor implements IFileAccessor {

    @Override
    public void createFile(String folderPath, String filename, CharSequence contents) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        FileWriter outputStream = null;
        File file = null;
        try {
            // Referring a file by a relative name.
            file = new File(folderPath, filename);

            // If the file existed before check the content
            if (file.exists()) {
                long fileCheckSum = calculateFileCheckSum(file);
                long contentCheckSum = calculateCharSequenceCheckSum(contents);
                // Same content do not write again!
                if (fileCheckSum == contentCheckSum) {
                    return;
                }
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
                outputStream = new FileWriter(file);
                outputStream.append(contents);
                outputStream.flush();

            }

            outputStream = new FileWriter(file);
            outputStream.append(contents);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    @Override
    public void deleteFile(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folderPath, fileName);
        file.delete();
    }

    @Override
    public void createFolder(String folderPath, String folderName) {
        File folder = new File(folderPath, folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    @Override
    public void createProject(String projectPath, String projectName) {
        File project = new File(projectPath, projectName);
        if (!project.exists()) {
            project.mkdirs();
        }
        createFolder(project.getAbsolutePath(),"src");
    }

    private long calculateFileCheckSum(File file) throws IOException {
        byte[] fileByteArray = Files.toByteArray(file);
        return calculateCheckSum(fileByteArray);
    }

    private long calculateCheckSum(byte[] byteArray) {
        Adler32 a32 = new Adler32();
        a32.update(byteArray);
        return a32.getValue();
    }

    private long calculateCharSequenceCheckSum(CharSequence content) {
        byte[] byteArray = new byte[content.length()];
        for (int i = 0; i < content.length(); i++) {
            byteArray[i] = (byte) content.charAt(i);
        }
        return calculateCheckSum(byteArray);
    }
}
