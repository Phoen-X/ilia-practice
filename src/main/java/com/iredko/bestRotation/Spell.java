package com.iredko.bestRotation;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class Spell {

    private String name;
    private int cooldown;
    private boolean canUse=true;
    private int canUseTime=0;

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
