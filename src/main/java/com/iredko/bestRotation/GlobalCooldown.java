package com.iredko.bestRotation;

/**
 * Created by ItsEasy on 01.08.2017.
 *
 */
public class GlobalCooldown {
    //Указывает на запрет со стороны глобал кд true - запрет отсутстувует
    private boolean castEnable = true;

    public void setCastEnable(boolean castEnable) {
        this.castEnable = castEnable;
    }

    public boolean isCastEnable() {
        return castEnable;
    }
}
