package com.iredko.testBook;

interface Payable<T> {
}

class Employee1 implements Payable<Employee1>{}

//class Hourly extends Employee1 implements Payable<Hourly> {}