package homework1;

public class Lorry extends CargoTruck {
    @Override
    public void turnLeft() {
        System.out.println("Lorry turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("Lorry turning right");
    }

    @Override
    public void tires() {
        System.out.println("Lorry has 8 Tires");
    }
}
