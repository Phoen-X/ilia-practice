package com.iredko.testBook;

import com.iredko.sql.City;

import javax.sound.midi.ShortMessage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ItsEasy on 16.10.2017.
 */
public abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimention;
    private static Random random = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xPos, int yPos, int dimention) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimention = dimention;
    }

    @Override
    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[ " + dimention + "]\n";
    }

    public static Shape randomFactory() {
        int xVal = random.nextInt(100);
        int yVal = random.nextInt(100);
        int dim = random.nextInt(100);
        switch (counter++%3) {
            default:
                case 0:
                    return new Circle(xVal, yVal, dim);
                case 1:
                    return new Square(xVal, yVal, dim);
                case 2:
                    return new Line(xVal, yVal, dim);


        }
    }
}

class Circle extends Shape {
    private static int color = RED;

    public Circle(int xPos, int yPos, int dimention) {
        super(xPos, yPos, dimention);
    }

    @Override
    public void setColor(int color) {
        Circle.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    public Square(int xPos, int yPos, int dimention) {
        super(xPos, yPos, dimention);
        color = RED;
    }

    @Override
    public void setColor(int color) {
        Square.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeInt(color);
    }

    public static void deserialezeStaticState(ObjectInputStream inputStream) throws IOException {
        color = inputStream.readInt();
    }

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}
