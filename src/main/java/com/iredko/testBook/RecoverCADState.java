package com.iredko.testBook;

import java.io.*;
import java.util.List;

/**
 * Created by ItsEasy on 16.10.2017.
 */
public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/CADstate.out"));
        //Данные считываются в том порядке , в котором они были записаны
        List<Class<?extends Shape>> shapeTypes = (List<Class<? extends Shape>>) inputStream.readObject();
        Line.deserialezeStaticState(inputStream);
        List<Shape> shapes = (List<Shape>)inputStream.readObject();
        System.out.println(shapes);
    }
}