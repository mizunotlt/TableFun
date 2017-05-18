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

    public boolean removeXY(Double x) {
        return tableFun.remove(x) != null;

    }

    public List<Pairs> showAll() {
        List<Pairs> result = new ArrayList<>();
        for (Double x : tableFun.keySet()) {
            result.add(new Pairs(x , tableFun.get(x)));
        }
        return result;
    }

    public Pairs findXY(Double  value) {

        Map.Entry<Double, Double> leftPoint = tableFun.floorEntry(value);
        Map.Entry<Double, Double> rightPoint = tableFun.ceilingEntry(value);
        if ((leftPoint == null) && (rightPoint == null)) {
            return null;
        }else
            if ((rightPoint != null) && (leftPoint != null)) {
                if (abs(leftPoint.getKey() - value) < abs(rightPoint.getKey() - value)) {
                    return new Pairs(leftPoint.getKey(), leftPoint.getValue());
                } else
                    return new Pairs(rightPoint.getKey(), rightPoint.getValue());
            }
            else {
                return leftPoint == null ? new Pairs(rightPoint.getKey(), rightPoint.getValue()) :
                        new Pairs(leftPoint.getKey(), rightPoint.getValue());
            }
        }

    public Double interpolXY(Double value) {
        Map.Entry<Double, Double> leftBorder = tableFun.floorEntry(value);
        Map.Entry<Double, Double> rightBorder = tableFun.ceilingEntry(value);
        if ((leftBorder != null) && (rightBorder != null))
            return leftBorder.getValue() +
                    ((rightBorder.getValue() - leftBorder.getValue())/(rightBorder.getKey() -
                            leftBorder.getKey()))*(value - leftBorder.getKey());
            return null;
    }
}
