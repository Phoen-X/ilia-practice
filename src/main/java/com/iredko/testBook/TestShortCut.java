package com.iredko.testBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestShortCut {
    public static void main(String[] args) throws IOException {
        final File blah = new File("blah");
        BufferedReader reader = new BufferedReader(new FileReader(blah));
        List<String> strings = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        final List<Shelf> shelves = new ArrayList<>();
        List<String> strings1 = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                strings.add(line);
            }
        }
        reader.close();
    }
}