public class Burger extends Food {

    @Override
    public void describeFood() {
        System.out.println("Burger: " + description);
    }

    @Override
    public void showPrice() {
        System.out.println("Price: " + price + " EUR");
    }
}


