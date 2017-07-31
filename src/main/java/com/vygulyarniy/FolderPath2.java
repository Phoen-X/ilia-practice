package com.vygulyarniy;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by IRedko on 31.07.2017.
 */
public class FolderPath2 {

    public static void main(String[] args) {
        FolderPath2 folderPath = new FolderPath2();
        folderPath.checkFolder("D:\\b", " ");
    }

    public void checkFolder(String testPath, String index) {
        File path = new File(testPath);
        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(index + file.getName());
                }

                if (file.isDirectory()) {
                    System.out.println(index + file.getName());
                    checkFolder(file.getAbsolutePath(), index + " ");

                }
            }
        }
    }
}