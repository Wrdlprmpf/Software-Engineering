package at.aau.ue5.bsp4;

public class SmellyClass {

    public void erstelleRechnung(Order order) {
        //calculate temporary price
        Double totalPrice=0.0d;
        //totalPrice += calculatePrice(order);
        totalPrice += order.calculatePrice();

        totalPrice += order.shippingCosts();

        //check for shipping costs
        //totalPrice += shippingCosts(order);

        System.out.println("Rechnung:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName()+": "+item.getPrice());
        }
        System.out.println("Total: "+totalPrice);
    }

}
