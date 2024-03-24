package org.prog.cars;

public class Ford implements ICar {
    @Override
    public void goTo() {
        System.out.println("Ford uses diesel engine!");
    }

    @Override
    public void fillCar() {

    }
}
