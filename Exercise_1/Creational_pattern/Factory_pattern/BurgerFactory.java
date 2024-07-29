package Creational_pattern.Factory_pattern;

public class BurgerFactory {
    public static Burger createBurger(String type) {
        switch (type.toLowerCase()) {
            case "veggie":
                return new VeggieBurger();
            case "cheese":
                return new CheeseBurger();
            case "chicken":
                return new ChickenBurger();
            default:
                throw new IllegalArgumentException("Unknown burger type: " + type);
        }
    }
}
