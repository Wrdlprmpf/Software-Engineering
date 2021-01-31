package at.aau.ue5.bsp4;

import java.util.List;

public class Order {

    private Long id;
    private Customer customer;
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double calculatePrice(){
        double price=0.0d;
        for (Item item : this.items) {
            price+=item.getPrice();
        }
        return price;
    }

    public double addShippingCostsToPrice(){
        double price = this.calculatePrice();
        if(price<=100) {
            Item item = new Item();
            item.setId(99L);
            item.setName("Porto und Versand");
            if(price>90) {
                item.setPrice(price*0.05);
            } else if(price>50) {
                item.setPrice(7.5d);
            } else {
                item.setPrice(10d);
            }
            this.items.add(item);
        }
        return price;
    }

}
