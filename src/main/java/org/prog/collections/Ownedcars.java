package org.prog.collections;

import java.util.*;

public class Ownedcars {
    public static void main(String[] args) {


        HashMap<Car, String> ownedCars = new HashMap<>();
        ownedCars.put(new Car(CarColors.GREEN), "Victoria");
        ownedCars.put(new Car(CarColors.BLACK), "Nikolas");
        ownedCars.put(new Car(CarColors.RED), "Nikolas");
        ownedCars.put(new Car(CarColors.WHITE), "Maria");
        ownedCars.put(new Car(CarColors.GREEN), "Albert");
        ownedCars.put(new Car(CarColors.RED), "Bill");
        ownedCars.put(new Car(CarColors.BLACK), "Victor");
        List<Car> carWithCertainColor = new ArrayList<>();
        Set<Car> cars = ownedCars.keySet();
        for (Car c : cars) {
            if (c.carColor.equals(CarColors.GREEN)) {
                carWithCertainColor.add(c);
            }
        }

        for (Car c : carWithCertainColor) {
            System.out.println(ownedCars.get(c));
        }
    }
}
