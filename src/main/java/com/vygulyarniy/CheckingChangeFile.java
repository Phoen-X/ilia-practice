package com.vygulyarniy;

import java.io.File;

/**
 * Created by IRedko on 21.07.2017.
 */
public class CheckingChangeFile {

    public static void main(String[] args) {
        CheckingChangeFile myCCF = new CheckingChangeFile();
        myCCF.chekingChangeFile("D:\\b\\source\\com\\iredko");
    }

    public void chekingChangeFile(String testPath){
        File path = new File(testPath);
    }
}
