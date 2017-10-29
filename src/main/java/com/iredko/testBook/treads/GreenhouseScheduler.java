package com.iredko.testBook.treads;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ItsEasy on 29.10.2017.
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    public synchronized String getThermostat(){
        return thermostat;
    }
    public synchronized void setThermostat(String value){
        thermostat = value;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MICROSECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MICROSECONDS);
    }

    class LightOn implements Runnable {
        @Override
        public void run() {
            //Сюда помещается аппаратный вызов, выполняющий физическое включение света
            System.out.println("Свет включен");
            light = true;
        }
    }

    class LightOff implements Runnable {
        @Override
        public void run() {
            //Сюда помещается аппаратный вызов, выполняющий физическое выключение света
            System.out.println("Свет выключен");
            light = false;
        }
    }

    class WaterOn implements Runnable {
        @Override
        public void run() {
            //Сюда помещается аппаратный вызов, выполняющий физическое включение полива
            System.out.println("Полив включен");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        @Override
        public void run() {
            //Сюда помещается аппаратный вызов, выполняющий физическое выключение полива
            System.out.println("Полив выключен");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            //Код управления оборудованием
            System.out.println("Включение ночного режима");
            setThermostat("Ночь");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            //Код управления оборудованием
            System.out.println("Включение дневного режима");
            setThermostat("День");
        }
    }

    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Бам!");
        }
    }

    class Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println("Завершение");
            scheduler.shutdownNow();
            //Для выполнения этой задачи необходимо запустить отдельную задачу , так как планировщик был отключен
            new Thread(){
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }

    class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        public String toString() {
            return time.getTime() + String.format(" температура: %1$.1f влажность: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();
    {
        //Регулировка даты до получаса
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable {
        @Override
        public void run() {
            System.out.println("Сбор данных");
            synchronized (GreenhouseScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                //С вероятностью 1/5 происходит смена направления
                if (rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                //Соранить предыдущее значение
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * (1.0f + rand.nextFloat());
                //Объект Календар неоюходимо клонировать, иначе все ДатаПоинт будут содерхать ссылки на
                // одно и тоже lastTime, для базового объекта как Календар - вызова clone() достаточно
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        gh.repeat(gh.new Bell(), 0, 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOn(), 0, 800);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new CollectData(), 500, 500);
    }









}
