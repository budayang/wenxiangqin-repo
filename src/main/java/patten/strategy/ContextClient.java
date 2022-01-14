package patten.strategy;

public class ContextClient {
    private DiscountStrategy ds;
    public ContextClient(DiscountStrategy ds) {
        this.ds = ds;
    }
    public double contextCalDis() {
        return ds.calculateDiscount();
    }

    public static void main(String[] args) {
        DiscountStrategy ds1 = new NoDiscountStrategy( 48.5, 20);
        DiscountStrategy ds2 = new FixDiscountStrategy( 48.5, 20);
        DiscountStrategy ds3 = new PercentageDiscountStrategy( 48.5, 20);
        System.out.println("0折扣：" + ds1.calculateDiscount());
        System.out.println("固定折扣：" + ds2.calculateDiscount());
        System.out.println("百分比折扣：" + ds3.calculateDiscount());
    }

}
