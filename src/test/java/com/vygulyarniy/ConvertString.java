package com.vygulyarniy;

/**
 * Created by IRedko on 19.07.2017.
 */
public class ConvertString {


    public String convertString(String text){
        char[] charList = text.toCharArray();
        int maxMassive=charList.length-1;
        char [] convertList = new char[charList.length];
        int minMassive=0;

        for (int i=0; i<charList.length; i++){
            convertList[maxMassive]=charList[minMassive];

            maxMassive--;
            minMassive++;

        }
        String convertString=new String(convertList);
        return convertString;
    }

    public static void main(String[] args) {
         ConvertString cs = new ConvertString();
         System.out.println(cs.convertString("привет как дела 1"));
    }

}
