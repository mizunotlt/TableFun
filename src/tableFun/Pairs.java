package tableFun;


import java.util.Objects;

public class Pairs {
    private Double x;
    private Double y;

    public Pairs(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        Pairs pair = (Pairs) o;
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        return ((Objects.equals(this.x, pair.x)) && (Objects.equals(this.y, pair.y)));
    }
}