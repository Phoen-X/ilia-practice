package com.iredko.bestRotation;

/**
 * Created by ItsEasy on 01.08.2017.
 *
 */
public class GlobalCooldown {
    //Указывает на запрет со стороны глобал кд true - запрет отсутстувует
    private boolean gcd = true; //TODO так назови эти вещи так чтобы было понятно когда запрет а когда нет. castEnabled?

    public void setGcd(boolean gcd) {
        this.gcd = gcd;
    }

    public boolean isGcd() {
        return gcd;
    }
}
