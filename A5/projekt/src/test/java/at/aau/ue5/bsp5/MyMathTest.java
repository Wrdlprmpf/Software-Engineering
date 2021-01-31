package at.aau.ue5.bsp5;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyMathTest {
    MyMath math = new MyMath();
    private double x = 10d;
    private double y = 5d;
    private Fraction f = new Fraction();


    @Test
    public void testAdd(){
        assertEquals(15d, (double)math.add(x,y));
    }

    @Test
    public void testSub(){
        assertEquals(5d, (double)math.sub(x,y));
    }

    @Test
    public void testMul(){
        assertEquals(50d, (double)math.mul(x,y));
    }

    @Test
    public void testDiv(){
        assertEquals(2d, (double)math.div(x,y));
    }


    @Test
    public void shouldReturn1And1_WhenInputIs1And1(){
        setNumAndDenum(1,1);

        assertEquals(new Fraction(1,1), math.reduce(f));
    }

    @Test
    public void shouldReturn5And3_WhenInputIs10And6(){
        setNumAndDenum(10,6);

        assertEquals(new Fraction(5,3),math.reduce(f));
    }

    @Test
    public void shouldReturn2And1_WhenInputIs10And5(){
        setNumAndDenum(10,5);

        assertEquals(new Fraction(2,1),math.reduce(f));
    }
    /*
    @Test
    public void x2() {
        Fraction f = new Fraction(1,1);
        MyMath mm = new MyMath();
        Fraction reduced = mm.reduce(f);
        assertEquals(new Integer(1),reduced.getNumerator());
        assertEquals(new Integer(1),reduced.getDenumerator());

        f = new Fraction(10,6);
        mm = new MyMath();
        reduced = mm.reduce(f);
        assertEquals(new Integer(5),reduced.getNumerator());
        assertEquals(new Integer(3),reduced.getDenumerator());

        f = new Fraction(10,5);
        mm = new MyMath();
        reduced = mm.reduce(f);
        assertEquals(new Integer(2),reduced.getNumerator());
        assertEquals(new Integer(1),reduced.getDenumerator());

        f = new Fraction(10,5);
        mm = new MyMath();
        Double aDouble = mm.toDouble(f);
        assertEquals(new Double(2),aDouble);

        f = new Fraction(10,4);
        mm = new MyMath();
        aDouble = mm.toDouble(f);
        assertEquals(new Double(2.5d),aDouble);
    }

     */

    @Test
    public void shouldReturn2d_WhenInputIs10And5(){
        setNumAndDenum(10,5);

        assertEquals(2, (double)math.toDouble(f));
    }

    @Test
    public void shouldReturn2dot5_WhenInputIs10And4(){
        setNumAndDenum(10,4);

        assertEquals(2.5, (double)math.toDouble(f));
    }

    public void setNumAndDenum(int numerator, int denumerator){
        this.f.setNumerator(numerator);
        this.f.setDenumerator(denumerator);
    }
}
