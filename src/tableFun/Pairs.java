package tableFun;


public class Pairs {
    private Double x;
    private Double y;

    public Pairs(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")" ;
    }
    @Override
    public boolean equals(Object o){
        Pairs pair = (Pairs) o;
        if (this == o) return  true;
        return ((this.x == pair.x) && (this.y == pair.y));

    }


}
