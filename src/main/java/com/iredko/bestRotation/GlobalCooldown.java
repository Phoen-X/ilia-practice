package com.iredko.bestRotation;

/**
 * Created by ItsEasy on 01.08.2017.
 *
 */
public class GlobalCooldown {

    private int canUseTime;
    private static int cooldownTime=1;

    public void setCanUseTime(int canUseTime) {
        this.canUseTime = canUseTime;
    }

    public static void setCooldownTime(int cooldownTime) {
        GlobalCooldown.cooldownTime = cooldownTime;
    }

    public int getCanUseTime() {
        return canUseTime;
    }

    public static int getCooldownTime() {
        return cooldownTime;
    }
}
