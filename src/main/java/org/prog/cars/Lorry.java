package org.prog.cars;

class Lorry extends CargoTruck {
    String driver;

    public Lorry(String name, int wheels, double cargoCapacity, double maxLoad) {
        super(name, wheels, cargoCapacity, maxLoad);
    }

    public void turn() {
        System.out.println("Lorry  + name +  turns slowly and carefully due to its size and cargo.");
    }
}

