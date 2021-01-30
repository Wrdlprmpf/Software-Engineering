package at.aau.ue5.bsp4;

public class SmellyClass {

    public void erstelleRechnung(Order order) {
        Double totalPrice=0.0d;
        //Berechne Preis
        totalPrice += order.calculatePrice();
        //Berechne Lieferkosten
        totalPrice += order.shippingCosts();
        //Rechnung ausgeben
        printBill(totalPrice, order);
    }

    public void printBill(Double totalPrice, Order order){
        System.out.println("Rechnung:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName()+": "+item.getPrice());
        }
        System.out.println("Total: "+totalPrice);
    }
}
