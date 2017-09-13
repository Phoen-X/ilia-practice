package com.iredko.testBook;

/**
 * Created by IRedko on 13.09.2017.
 */
public class Person {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class NullPerson extends Person implements MyNull{

        public NullPerson() {
            super("None", "None","None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    public static final Person NULL = new NullPerson();
}
