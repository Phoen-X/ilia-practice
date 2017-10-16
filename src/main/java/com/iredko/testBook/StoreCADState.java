package com.iredko.testBook;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ItsEasy on 16.10.2017.
 */
public class StoreCADState {
    public static void main(String[] args) throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
        //Добавление ссылок на объекты класа
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);
        List<Shape> shapes = new ArrayList<Shape>();
        //Создание фигур:
        for (int i =0;i<10;i++) {
            shapes.add(Shape.randomFactory());
        }
        //Назначение всех статических цветов:
        for (int i = 0; i<10;i++) {
            ((Shape) shapes.get(i)).setColor(Shape.GREEN);
        }
        //Сохранение вектора состояния
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/CADstate.out"));
        outputStream.writeObject(shapeTypes);
        Line.serializeStaticState(outputStream);
        outputStream.writeObject(shapes);
        //Вывод фигуры
        System.out.println(shapes);
    }
}
