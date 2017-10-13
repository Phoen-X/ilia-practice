package com.iredko.testBook;

import java.io.*;

public class SerialCtl implements Serializable {
    private String string;
    private transient String transString;

    public SerialCtl(String string, String trString) {
        this.string = "Не объявлено transient: " + string;
        this.transString ="Объявлено transient" +  trString;
    }

    @Override
    public String toString() {
        return string + "\n" + transString;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(transString);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.transString = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl serialCtl = new SerialCtl("Test1", "Test2");
        System.out.println("Перед записью \n" + serialCtl);
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteOutStream);
        outputStream.writeObject(serialCtl);
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteOutStream.toByteArray()));
        SerialCtl innerSerialCtl = (SerialCtl) inputStream.readObject();
        System.out.println("После востановления: \n" + innerSerialCtl);
    }
}
