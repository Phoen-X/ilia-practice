package com.vygulyarniy;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by IRedko on 31.07.2017.
 */
public class FolderPath2 {
    String a = " ";

    public static void main(String[] args) {
        FolderPath2 folderPath = new FolderPath2();
        folderPath.check("D:\\b");
    }

    public ArrayList checkFolder(String testPath) {
        File path = new File(testPath);
        File[] files = path.listFiles();
        ArrayList<File> innerList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                innerList.add(file);
            }
        }
        return innerList;
    }

    public void check(String path) {
        File pathAll = new File(path);
        File[] files = pathAll.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile())
                    System.out.println(file.getName());
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(file.getName());
                    ArrayList<File> list = checkFolder(file.getAbsolutePath());
                    for (File inList : list) {
                        System.out.println(a + inList.getName());
                        if (inList != null) {
                            check(inList.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}





