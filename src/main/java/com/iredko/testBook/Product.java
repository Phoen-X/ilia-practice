package com.iredko.testBook;

import java.util.Random;

/**
 * Created by IRedko on 22.09.2017.
 */
public class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ", " + description + ", " + price;
    }

    public void priceChange(double change){
        price +=change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random random = new Random(47);
        @Override
        public Product next() {
            return new Product(random.nextInt(1000),"Test", Math.round(random.nextDouble()*1000.0)+0.99);
        }
    };
}
