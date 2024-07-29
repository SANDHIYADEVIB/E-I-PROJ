package Creational_pattern.Factory_pattern;

public class CheeseBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing cheese burger...");
    }

    @Override
    public void cook() {
        System.out.println("Cooking cheese burger...");
    }

    @Override
    public void box() {
        System.out.println("Boxing cheese burger...");
    }
}
