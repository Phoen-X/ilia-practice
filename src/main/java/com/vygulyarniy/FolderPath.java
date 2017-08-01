package com.vygulyarniy;

import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IRedko on 31.07.2017.
 */
public class FolderPath {

    public static void main(String[] args) {
        FolderPath folderPath = new FolderPath();
        folderPath.checkFolder("D:\\");
    }

    public void checkFolder(String testPath) {
        File path = new File(testPath);
        File[] files = path.listFiles();
        List<String> filesInDirectory = new ArrayList<>();
        List<String> folderInDirectory = new ArrayList<>();

        if(files!=null){
            for (File file : files) {
                if (file.isDirectory()) {
                    folderInDirectory.add(file.getName());
                    checkFolder(file.getAbsolutePath());
                }
                if (file.isFile()) {
                    filesInDirectory.add(file.getName());
                }
            }
            System.out.println("Файлы в директории " + testPath + " :" + filesInDirectory);
            System.out.println("Папки в директории " + testPath + " :" + folderInDirectory);
        }
    }
}




