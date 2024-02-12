package org.prog.cars;

class Truck extends Vehicle {
    double cargoCapacity;

    public Truck(String name, int wheels, double cargoCapacity) {
        super();
        this.cargoCapacity = cargoCapacity;
    }
    public void turn() {
        System.out.println("Cargo truck " + " turns carefully .");
    }
}

