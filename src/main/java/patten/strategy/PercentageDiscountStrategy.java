package patten.strategy;

public class PercentageDiscountStrategy extends DiscountStrategy {

    public PercentageDiscountStrategy(double price, int number) {
        super(price, number);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * getNumber() * 0.15;
    }
}
