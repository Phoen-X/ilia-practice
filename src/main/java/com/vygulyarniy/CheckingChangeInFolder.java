package com.vygulyarniy; /**
 * Created by IRedko on 20.07.2017.
 */

import java.nio.file.*;
import java.io.IOException;


public class CheckingChangeInFolder {

    public static void main(String[] args) {
        CheckingChangeInFolder checkFolder = new CheckingChangeInFolder();
        checkFolder.checkChangeInFolder("D:\\b\\source\\com\\iredko");
    }

    public void checkChangeInFolder(String pathForDirectory){
        Path path = Paths.get(pathForDirectory);
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(;;){
            WatchKey key = null;
            try{
                key = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(WatchEvent event: key.pollEvents()){
                switch (event.kind().name()){
                    case "OVERFLOW":
                        System.out.println("We lost some event");
                        break;
                    case "ENTRY_CREATE":
                        System.out.println("File "+ event.context() + " is created!");
                        break;
                    case  "ENTRY_MODIFY":
                        System.out.println("File " + event.context() + "is modified!");
                        break;
                    case  "ENTRY_DELETE":
                        System.out.println("File " + event.context() + "is deleted!");
                        break;
                }
            }
            key.reset();
        }
    }
}
