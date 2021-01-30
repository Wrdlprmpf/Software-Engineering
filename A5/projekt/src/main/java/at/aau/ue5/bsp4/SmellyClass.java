package at.aau.ue5.bsp4;

public class SmellyClass {

    public void erstelleRechnung(Order order) {

        //calculate temporary price
        Double totalPrice=0.0d;
        totalPrice += calculatePrice(order);

        //check for shipping costs
        totalPrice += shippingCosts(order);

        System.out.println("Rechnung:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName()+": "+item.getPrice());
        }
        System.out.println("Total: "+totalPrice);
    }

    public double calculatePrice(Order order){
        Double price=0.0d;
        for (Item item : order.getItems()) {
            price+=item.getPrice();
        }
        return price;
    }

    public double shippingCosts(Order order){
        Double price =0.0d;

        if(price<=100) {
            Item item = new Item();
            item.setId(99l);
            item.setName("Porto und Versand");
            if(price>90) {
                item.setPrice(price*0.05);
            } else if(price>50) {
                item.setPrice(7.5d);
            } else {
                item.setPrice(10d);
            }
            order.getItems().add(item);
        }
        return price;
    }


}
