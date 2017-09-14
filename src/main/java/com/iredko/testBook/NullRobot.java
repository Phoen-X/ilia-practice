package com.iredko.testBook;

import java.lang.reflect.Proxy;

/**
 * Created by IRedko on 14.09.2017.
 */
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{MyNull.class, Robot.class},
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] bots = {new SnowRemovalRobot("Snowbee"), newNullRobot(SnowRemovalRobot.class)};
        for (Robot bot: bots){
            Robot.Test.test(bot);
        }
    }

}
