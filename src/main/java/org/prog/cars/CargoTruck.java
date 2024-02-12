package org.prog.cars;

class CargoTruck extends Truck {
    double maxLoad;

    public CargoTruck(String name, int wheels, double cargoCapacity, double maxLoad) {
        super(name, wheels, cargoCapacity);
        this.maxLoad = maxLoad;
    }

    public void turn() {
        String name;
        System.out.println("Cargo truck "  + " turns carefully due to its cargo.");
    }
}

