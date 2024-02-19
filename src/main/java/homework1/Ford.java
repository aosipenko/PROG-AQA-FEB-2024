package homework1;

public class Ford implements ICar {
    @Override
    public void energyType() {
        System.out.println("Ford needs gas");
    }

    @Override
    public void navigation() {
        System.out.println("Ford is to old without navigation");
    }

    @Override
    public void autoPilot() {
        System.out.println("Ford is without autopilot");
    }

    @Override
    public void bluetooth() {
        System.out.println("No bluetooth");
    }

    @Override
    public void idNo() {
        System.out.println("1111122222333344444");
    }
}
