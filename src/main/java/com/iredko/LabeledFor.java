package com.iredko;

/**
 * Created by IRedko on 28.07.2017.
 */
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        outer:
        for(;true;){
            inner:
            for (;i<10;i++){
                System.out.println("i= " +i);
                if(i==2){
                    System.out.println("comtinue");
                    continue ;
                }
                if(i==3){
                    System.out.println("break");
                    i++;
                    break ;
                }
                if(i==7){
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if(i==8){
                    System.out.println("break outer");
                    break outer;
                }
                for(int k=0;k<5;k++){
                    System.out.println("continue inner");
                    continue inner;
                }
                if(i==9){
                    System.out.println("i=9");
                }
            }
        }
    }
}
