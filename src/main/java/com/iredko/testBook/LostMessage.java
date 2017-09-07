package com.iredko.testBook;

/**
 * Created by IRedko on 06.09.2017.
 */
public class LostMessage {
    void f()throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException{
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try{
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            }finally {
                lm.dispose();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
