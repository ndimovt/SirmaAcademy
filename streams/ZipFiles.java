package io.github.ndimovt.streams;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\archives.zip");
        File dir = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\extracted_files");
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            ZipInputStream zis = new ZipInputStream(bis);
            ZipEntry zipEntity;
            while ((zipEntity = zis.getNextEntry()) != null) {
                String entity = zipEntity.getName();
                if(entity.endsWith(".txt")){
                    File textFile = new File(dir, entity);

                    File parentDir = textFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(textFile))){
                        int len;
                        byte[] buffer = new byte[1024];
                        while((len = zis.read(buffer)) > 0){
                            bos.write(buffer,0, len);
                        }
                    }
                }
                zis.closeEntry();
            }

        } catch (IOException ie) {
                ie.printStackTrace();
        }
    }
}
