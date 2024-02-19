package homework1;

public class Honda implements ICar {
    @Override
    public void energyType() {
        System.out.println("Honda uses a diesel");
    }

    @Override
    public void navigation() {
        System.out.println("Honda have a navigation");
    }

    @Override
    public void autoPilot() {
        System.out.println("Honda doesn't have an AutoPilot");
    }

    @Override
    public void bluetooth() {
        System.out.println("Honda has a bluetooth connection");
    }

    @Override
    public void idNo() {
        System.out.println("0987654321");
    }
}
