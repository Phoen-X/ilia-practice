package com.iredko.testBook;

import java.io.File;

public class MakeDirectories {
    private static void usage() {
        System.err.println(
                "Использование:MakeDirectories путь1 ...\n" +
                        "Создает все пути\n" +
                        "Использование:MakeDirectories -d путь1 ...\n" +
                        "Удаляет все пути \n" +
                        "Использование:MakeDirectories -r путь1 путь2\n" +
                        "Переименовывает путь1 в путь2\n");
        System.exit(1);
    }

    private static void fileData(File file) {
        System.out.println(
                "Полное имя: " + file.getAbsolutePath() +
                        "\n доступно для чтения: " + file.canRead() +
                        "\n доступно для записи: " + file.canWrite() +
                        "\n имя файла getName(): " + file.getName() +
                        "\n родительский каталог getParent(): " + file.getParent() +
                        "\n путь getPath(): " + file.getPath() +
                        "\n рaзмер: " + file.length() +
                        "\n последнее изменение: " + file.lastModified());
        if (file.isFile()) {
            System.out.println("Это файл");
        } else {
            System.out.println("Это каталог");
        }
    }

    public static void main(String[] args) {
        if(args.length<1){
            usage();
        }
        if (args[0].equals("-r")) {
            if (args.length != 3) {
                usage();
            }
            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del  = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(args[count]);
            if (f.exists()) {
                System.out.println(f + " существует");
                if (del) {
                    System.out.println("удаление " + f);
                    f.delete();
                }
            } else {
                if (!del) {
                    f.mkdir();
                    System.out.println("созданно " + f);
                }
            }
            fileData(f);
        }
    }
}
