package homework1;

public class Tesla implements ICar {

    @Override
    public void energyType() {
        System.out.println("Tesla uses Electric");
    }

    @Override
    public void navigation() {
        System.out.println("Tesla has a navigation");
    }

    @Override
    public void autoPilot() {
        System.out.println("Tesla has an AutoPilot");
    }

    @Override
    public void bluetooth() {
        System.out.println("Tesla has a bluetooth");
    }

    public void playMario() {
        System.out.println("In Tesla you can play games");
    }

    @Override
    public void idNo() {
        System.out.println("1234567890");
    }

}
