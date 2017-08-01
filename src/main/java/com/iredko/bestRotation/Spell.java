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
    private boolean canUse=true; // TODO это поле не нужно. Оно вычисляемое (canUse = canUseTime == 0)
    //Переменная необходимая для определения промежутков времени запрета использования заклинания
    private int canUseTime=0; //TODO хреновое имя переменной. наверное это secondsUntilAvailable

    //TODO кажется мне ты не хочешь иметь возможность создать скил без имени и кулдауна.
    public Spell(){}

    public Spell(String name, int cooldown){
        setName(name);
        setCooldown(cooldown);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setCanUse(boolean canUse) {
        this.canUse = canUse;
    }

    public void setCanUseTime(int canUseTime) {
        this.canUseTime = canUseTime;
    }

    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isCanUse() {
        return canUse;
    }

    public int getCanUseTime() {
        return canUseTime;
    }
}
