package com.iredko.testBook;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by IRedko on 08.09.2017.
 */
public class SomeOtherException extends Exception {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);
        for(int i=0;i<4;i++){
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else throw new SomeOtherException();
            }catch (SomeOtherException e){
                System.out.println("SomeOtherException: "+ e);
            }catch (RuntimeException re){
                try{
                    throw re.getCause();
                }catch (FileNotFoundException e){
                    System.out.println("FileNotFoundException: "+e);
                }catch (IOException e){
                    System.out.println("IOException: "+e);
                }catch (Throwable e){
                    System.out.println("Throwable: "+e);
                }
            }
        }
    }
}
