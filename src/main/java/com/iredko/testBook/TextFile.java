package com.iredko.testBook;

import javax.xml.soap.Text;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    //Чтение файла как одной строки
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    //Запись файла за один вызов метода
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Чтение файла с разбиением по регулярному выражению
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    //Обычное простое чтение
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Проверка
    public static void main(String[] args) {
        String file = read("D:\\b\\source\\com\\Player.java");
        write("D:\\b\\source\\com\\test.txt", file);
        TextFile text = new TextFile("D:\\b\\source\\com\\test.txt");
        text.write("D:\\b\\source\\com\\test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("D:\\b\\source\\com\\Player.java","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
