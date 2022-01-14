package patten.strategy;

public abstract class DiscountStrategy {

    private double price;
    private int number;
    public DiscountStrategy(double price, int number) {
        this.price = price;
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public abstract double calculateDiscount();
}
