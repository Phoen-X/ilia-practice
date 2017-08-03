package com.iredko.bestRotation;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class Spell {
    //Имя Заклинания
    private String name;
    //Время восстановления заклинания
    private int cooldown;
    //Доступность заклинания для использования
    int canUseTime;

    public Spell(String name, int cooldown){
        setName(name);
        setCooldown(cooldown);
    }

    public void setCanUseTime(int canUseTime) {
        this.canUseTime = canUseTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getCanUseTime() {
        return canUseTime;
    }

    @Override
    public String toString() {
        return name;
    }
}
