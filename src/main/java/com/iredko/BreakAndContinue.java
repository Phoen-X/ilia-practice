package com.iredko;

/**
 * Created by IRedko on 28.07.2017.
 */
public class BreakAndContinue {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            if(i==74) break;;
            if(i%9 !=0)continue;
            System.out.println(i+" ");
        }
    }
}
