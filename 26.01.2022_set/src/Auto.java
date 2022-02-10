import java.util.Comparator;

public class Auto implements Comparable<Auto>{

    private final String make;
    private final int year;

    public Auto(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public boolean equals(Auto o) {
        return this.make.equals(o.make) && this.year == o.year;
    }



    public int compareTo(Auto o) {
        if(this.make.equals(o.make)){
            return o.year - this.year;
        }
        else return this.make.compareTo(o.make);
    }

    @Override
    public String toString() {
        return make + ":" + year;
    }

    static class CarComparator implements Comparator<Auto> {

        @Override
        public int compare(Auto o1, Auto o2) {
            if(o1.make.equals(o2.make)){
                return o2.year - o1.year;
            }
            else return o1.make.compareTo(o2.make);
        }
    }
}

