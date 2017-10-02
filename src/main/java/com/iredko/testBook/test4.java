package com.iredko.testBook;

import java.util.Arrays;

public class test4 {
    ///////////////
    //////////////
    public void go2(int value){
        int c = 0;
        int [][] matrix = new int[value][value];

        for (int i = 0;i<value;i++){
            matrix[0][i]= c+1;
            c=c+1;
        }
        for (int i = 0;i<value-1;i++){
            matrix[i+1][value-1]=c+1;
            c=c+1;
        }
        for (int i=0;i<value-1;i++) {
            matrix[value-1][value-2-i]=c+1;
            c=c+1;
        }
        for (int i = 0;i<value-2;i++){
            matrix[value-2-i][0]=c+1;
            c=c+1;
        }
        ////////////////////////////////////
        for (int i = 0;i<value-2;i++){
            matrix[0+1][i+1]= c+1;
            c=c+1;
        }
        for (int i = 0;i<value-1-2;i++){
            matrix[i+1+1][value-1-1]=c+1;
            c=c+1;
        }
        for (int i=0;i<value-1-2;i++) {
            matrix[value-1-1][value-3-i]=c+1;
            c=c+1;
        }
        for (int i = 0;i<value-2-2;i++){
            matrix[value-2-1-i][0+1]=c+1;
            c=c+1;
        }
        System.out.println(Arrays.deepToString(matrix));


    }
}
