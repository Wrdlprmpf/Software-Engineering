package at.aau.ue5.bsp4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Order test = new Order();
		SmellyClass smell = new SmellyClass();

		Item a = new Item();
		a.setPrice(4.0);
		a.setId(123456l);
		a.setName("Kuchen");
		Item b = new Item();
		b.setPrice(1.20);
		b.setId(15001l);
		b.setName("Eis");
		Item c = new Item();
		c.setPrice(15.0);
		c.setId(93022l);
		c.setName("BananaSplit");

		ArrayList<Item> items = new ArrayList<Item>();
		items.add(a);
		items.add(b);
		items.add(c);

		test.setItems(items);

		smell.erstelleRechnung(test);
	}
}
