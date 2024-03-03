package org.prog.collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MapsDemo {
    public static void main(String[] args) {
        HashMap<Car, String> ownedCars = new HashMap<>();

        ownedCars.put(new Car(CarColors.BLUE), "Bob");
        ownedCars.put(new Car(CarColors.YELLOW), "Alice");
        ownedCars.put(new Car(CarColors.BLUE), "Sofia");
        ownedCars.put(new Car(CarColors.RED), "Eva");
        ownedCars.put(new Car(CarColors.WHITE), "Mark");
        ownedCars.put(new Car(CarColors.YELLOW), "Nasty");
        ownedCars.put(new Car(CarColors.RED), "Nasty");
        List<Car> carWithCertainColor = new ArrayList<>();
        Set<Car> cars = ownedCars.keySet();
        for (Car c : cars){
            if (c.carColor.equals(CarColors.BLUE)){
                carWithCertainColor.add(c);

            }
        }


        for (Car c : carWithCertainColor){
            System.out.println(ownedCars.get(c));
        }
    }

    }

