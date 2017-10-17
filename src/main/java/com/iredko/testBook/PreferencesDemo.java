package com.iredko.testBook;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(PreferencesDemo.class);
        preferences.put("Location", "Oz");
        preferences.put("Footwear", "Ruby Slippers");
        preferences.putInt("Companions", 4);
        preferences.putBoolean("Are there are witches?", true);
        int usageCount = preferences.getInt("UsageCount", 0);
        usageCount++;
        preferences.putInt("UsageCount", usageCount);
        for (String key : preferences.keys()) {
            System.out.println(key +": "+ preferences.get(key,null));
        }
        //Всегда необходимо указывать значение по умолчанию:
        System.out.println("How many companions does Dorothy have?"+preferences.getInt("Companions",0));

    }
}
