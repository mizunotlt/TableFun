package tableFun;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;


public class tableFun {

    private  Map<Double, Double> tableFun = new HashMap<Double, Double>();


    public  tableFun(HashMap<Double, Double> map ){
        this.tableFun = map;

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

    public ArrayList<String>  showAll(){
        ArrayList result = new ArrayList<String>();
        for (Double x : tableFun.values()){
            result.add("(" + x + ", " + tableFun.get(x) + ")");
        }
        return result;
    }

    public String findXY(Double  value){
        Double min = value;
        String result = "";
        for (Double x : tableFun.values()){
            if (abs(tableFun.get(x) - value) < min ){
                min = tableFun.get(x) ;
                result = "(" + x + ", " + tableFun.get(x) + ")";
            }

        }
        return result;
    }

    public Double interpolXY(Double value) {
        Double minL = value;
        Double minR = value;
        Double result;
        for (Double x : tableFun.values()){
            if (tableFun.get(x) < value) {
                if (abs(tableFun.get(x) - value) < minL) {
                    minL = tableFun.get(x);
                }
            }
            if (tableFun.get(x) > value){
                if (abs(tableFun.get(x) - value) < minR ){
                    minR = tableFun.get(x) ;
                }
            }
        }
        result = (value * ( tableFun.get(minR) - tableFun.get(minL)))/(minR - minL) + (tableFun.get(minL)* minR -
               tableFun.get(minR)*minL )/(minR - minL);
        return result;

    }


}
