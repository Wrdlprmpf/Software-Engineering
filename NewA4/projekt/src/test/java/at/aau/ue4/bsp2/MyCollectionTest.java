package at.aau.ue4.bsp2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class MyCollectionTest
{
    private MyCollection c;

    @BeforeEach
    public void setup() {
        c = new MyCollection(5);
        c.add("1");
        c.add("2");
        c.add("3");
    }
    @Test
    public void testSizeSimple() {
        assertEquals(3,c.size());
    }

    @Test
    public void shouldReduceByOne_whenOneIsRemoved(){
        assertEquals(3,c.size());
        c.remove("1");
        assertEquals(2,c.size());
    }

    @Test
    public void shouldEmpty_WhenExecuted(){
        c.empty();
        assertEquals(0,c.size());
    }
}
