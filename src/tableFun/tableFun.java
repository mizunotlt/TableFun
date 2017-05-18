package tableFun;

import java.util.*;

import static java.lang.StrictMath.abs;


public class tableFun {

    private NavigableMap<Double, Double> tableFun;



    public  tableFun ( ){
        this.tableFun = new TreeMap<>();

    }
    public  tableFun ( Map <Double, Double> fun){
        this.tableFun = new TreeMap<>(fun);

    }
    public double getXY(Double x) {
        return tableFun.get(x);

    }
    public void putXY(Double x, Double y){

        tableFun.put(x,y);
    }

    public tableFun removeXY(Double x) {
        tableFun.remove(x);
        return  this;
    }

    public List<Pairs> showAll() {
        List<Pairs> result = new ArrayList<>();
        for (Double x : tableFun.keySet()) {
            result.add(new Pairs(x , tableFun.get(x)));
        }
        return result;
    }

    public Pairs findXY(Double  value) {

        Double leftPoint = tableFun.floorKey(value);
        Double rightPoint = tableFun.ceilingKey(value);
        if ((leftPoint == null) && (rightPoint == null)) {
            return null;
        }else
            if ((rightPoint != null) && (leftPoint != null)) {
                if (abs(leftPoint - value) < abs(rightPoint - value)) {
                    return new Pairs(leftPoint, tableFun.floorEntry(value).getValue());
                } else
                    return new Pairs(rightPoint, tableFun.ceilingEntry(value).getValue());
            }
            else {
                return leftPoint == null ? new Pairs(rightPoint, tableFun.ceilingEntry(value).getValue()) :
                        new Pairs(leftPoint, tableFun.floorEntry(value).getValue());
            }
        }

    public Double interpolXY(Double value) {
        Double leftBorder = tableFun.floorKey(value);
        Double rightBorder = tableFun.ceilingKey(value);

        if ((leftBorder != null) && (rightBorder != null))
            return tableFun.floorEntry(value).getValue() +
                    ((tableFun.ceilingEntry(value).getValue() -
                            tableFun.floorEntry(value).getValue())/(rightBorder - leftBorder))*(value - leftBorder);
        else
            return null;
    }
}
