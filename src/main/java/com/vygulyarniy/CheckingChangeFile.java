package com.vygulyarniy;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IRedko on 21.07.2017.
 */
public class CheckingChangeFile {
    File[] files;

    public static void main(String[] args) {
        CheckingChangeFile myCCF = new CheckingChangeFile();
        myCCF.chekingChangeFile("D:\\b\\source\\com\\iredko");
    }

    public void chekingChangeFile(String testPath) {
        File path = new File(testPath);
        files = path.listFiles();
        HashMap<File, Long> oldHash = new HashMap<>();

        for (File oldFile : files) {
            oldHash.put(oldFile, oldFile.lastModified());
        }
        for (; ; ) {
            HashMap<File, Long> currentHash = new HashMap<>();
            for (File currentFile : files) {
                currentHash.put(currentFile, currentFile.lastModified());
            }

            for (Map.Entry<File,Long> oldEntry : oldHash.entrySet()){
                if(currentHash.get(oldEntry.getKey())==null){
                    System.out.println(("Файл " + oldEntry.getKey() + " быд удален"));
                    oldHash = currentHash;
                }
            }

            for (Map.Entry<File, Long> newEntry: currentHash.entrySet()){
                if(oldHash.get(newEntry.getKey())==null){
                    System.out.println("Файл " + newEntry.getKey() + " был добавлен");
                    oldHash = currentHash;
                }
            }

            for(File oldFile : oldHash.keySet()){
                for (File currentFile : currentHash.keySet()){
                    if(currentFile.getName().equals(oldFile.getName())){
                        if(!oldHash.get(oldFile).equals(currentHash.get(currentFile))){
                            System.out.println("Изменился файл " + currentFile.getName());
                            oldHash = currentHash;
                        }
                    }
                }
            }


        }

    }


}