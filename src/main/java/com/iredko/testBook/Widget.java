package com.iredko.testBook;

public class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create(){
            return new Widget();
        }
    }
}
