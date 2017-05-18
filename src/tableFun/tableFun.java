package tableFun;

import java.util.*;


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

    public void removeXY(Double x) {

        tableFun.remove(x);
    }

    public List<Pairs> showAll() {
        List<Pairs> result = new ArrayList<>();
        for (Double x : tableFun.keySet()) {
            result.add(new Pairs(x , tableFun.get(x)));
        }
        return result;
    }

    public Pairs findXY(Double  value){
        try{
            return new Pairs(tableFun.floorKey(value), tableFun.get(tableFun.floorKey(value)));
        }catch (NullPointerException e){
            return new Pairs(null, null);
        }
    }

    public Double interpolXY(Double value) { //проверить на null и чуть дописать
        Double leftBorder = tableFun.floorKey(value);
        Double rightBorder = tableFun.ceilingKey(value);

        if (leftBorder == null)
            leftBorder = tableFun.firstKey();
        if (rightBorder == null)
            rightBorder = tableFun.lastKey();
        return tableFun.get(leftBorder) +
                ((tableFun.get(rightBorder) - tableFun.get(leftBorder))/(rightBorder - leftBorder))*(value - leftBorder);
    }

}
