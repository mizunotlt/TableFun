package tableFun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static java.lang.Math.abs;


public class tableFun {

    private  Map<Double, Double> tableFun;



    public  tableFun (Map <Double,Double> fun ){
        this.tableFun = fun;

    }
    public double getXY(Double x) {
        return tableFun.get(x);

    }
    public void putXY(Double x, Double y){

        tableFun.put(x,y);
    }

    public void removeXY(Double x) {

        tableFun.remove(x);
    }

    public ArrayList<Pairs> showAll() {
        ArrayList<Pairs> result = new ArrayList<>();
        for (Double x : tableFun.keySet()) {
            result.add(new Pairs(x , tableFun.get(x)));
        }
        return result;
    }

    public Pairs findXY(Double  value){
        Double min = value;
        Pairs result = new Pairs(0.0, 0.0);

        for (Double i : tableFun.keySet()){

            if (abs(tableFun.get(i) - value) < min ){
                min = abs(tableFun.get(i) - value) ;
               result  = new Pairs (i , tableFun.get(i));
            }

        }
        return result;
    }

    public Double interpolXY(Double value) {
        List <Double> x = new ArrayList<>();
        for (Double i : tableFun.keySet()){
            x.add(i);
        }
        Double leftBorder = x.get(0);
        Double rightBorder = x.get(x.size()-1);
        return tableFun.get(leftBorder) +
                ((tableFun.get(rightBorder) - tableFun.get(leftBorder))/(rightBorder - leftBorder))*(value - leftBorder);
    }

}
