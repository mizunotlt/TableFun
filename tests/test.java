import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tableFun.Pairs;
import tableFun.tableFun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class test {
    public Map<Double, Double> table = new TreeMap<Double, Double>();
    public Map<Double, Double> table1 = new TreeMap<Double, Double>();
    public tableFun fun = new tableFun(table);
    public tableFun fun1 = new tableFun(table1);
    public tableFun fun3 = new tableFun();
    @Before
    public void add() {
        fun.putXY(1.0, 2.0);
        fun.putXY(5.0, 8.0);
        fun.putXY(3.0, 4.5);
        fun.putXY(3.5, 2.12);
        fun1.putXY(12.45, 0.3);
        fun1.putXY(1.0, 3.45);
        fun1.putXY(4.5, 10.7);
        fun1.putXY(3.7, 1.67);
        fun1.putXY(6.23, 3.93);
        fun1.putXY(5.1, 13.5);

    }

    @Test
    public void getXY() {
        Assert.assertEquals(2.0, fun.getXY(1.0), 0.0);

    }

    @Test
    public void removeXY() {
        Assert.assertTrue(fun.removeXY(3.5));
        Assert.assertFalse(fun.removeXY(56.2));
    }

    @Test
    public void toStringTest(){
        Pairs pair1 = new Pairs(9.0,2.0);
        Pairs pair2= new Pairs(4.56, 3.12);
        Pairs pair3 = new Pairs(12.0,89.0);

        Assert.assertEquals("(9.0, 2.0)",pair1.toString());
        Assert.assertEquals("(4.56, 3.12)", pair2.toString());
        Assert.assertEquals("(12.0, 89.0)",pair3.toString());
    }

    @Test
    public void eaqualsTest(){
        Pairs pair1 = new Pairs(9.0,2.0);
        Pairs pair2= new Pairs(4.56, 3.12);

        Assert.assertTrue(new Pairs(9.0,2.0).equals(pair1));
        Assert.assertTrue(new Pairs(4.56,3.12).equals(pair2));
        Assert.assertFalse(new Pairs(0.0,2.8).equals(pair1));
    }


    @Test
    public void showAll() {
        List<Pairs> test = new ArrayList<>();
        test.add(new Pairs(1.0, 2.0));
        test.add(new Pairs(3.0, 4.5));
        test.add(new Pairs(3.5, 2.12));
        test.add(new Pairs(5.0, 8.0));
        Assert.assertEquals(test,fun.showAll());
    }

    @Test
    public void findXY(){

        Assert.assertEquals("(6.23, 3.93)",fun1.findXY(7.5).toString());
        Assert.assertEquals("(3.7, 1.67)", fun1.findXY(3.46).toString());
        Assert.assertEquals("(1.0, 3.45)",fun1.findXY(0.7).toString());
    }

    @Test
    public void interpolXY() {

        Assert.assertEquals(2.5, fun.interpolXY(1.4), 1e-5);
        Assert.assertEquals(3.35, fun1.interpolXY(1.15), 1e-2);
        Assert.assertEquals(1.76, fun1.interpolXY(3.57), 1e-2);
    }
}


