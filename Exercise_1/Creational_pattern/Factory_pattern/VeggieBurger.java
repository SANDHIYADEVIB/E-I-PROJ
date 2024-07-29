package Creational_pattern.Factory_pattern;

public class VeggieBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing veggie burger...");
    }

    @Override
    public void cook() {
        System.out.println("Cooking veggie burger...");
    }

    @Override
    public void box() {
        System.out.println("Boxing veggie burger...");
    }
}
