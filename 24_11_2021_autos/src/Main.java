public class Main {

    public static void main(String[] args) {

        Auto[] autos = getAutopark();
        //an example with equals
        Auto bentley = new Auto("Bentley", 2010, "Silver");
        System.out.println(containsAuto(autos, bentley));//true
        System.out.println(bentley);

        //an example with references
        swapAuto(bentley);
        System.out.println(containsAuto(autos, bentley));//false
        System.out.println(bentley);

    }

    static void swapAuto(Auto auto){
        auto.make = "Mercedes";
        Auto newAuto = new Auto ("Mercedes", 2021, "Black");
        auto = newAuto;
    }

    static boolean containsAuto(Auto[] autos, Auto auto){
        for (int i = 0; i < autos.length; i++) {
            if (autos[i].equals(auto))
                return true;
        }
        return false;
    }

    private static Auto[] getAutopark(){
        Auto opel = new Auto("Opel",2012, "Grey");
        Auto mazda = new Auto("Mazda",2015, "Red");
        Auto bentley = new Auto("Bentley",2010, "Silver");

        return new Auto[]{opel, mazda, bentley};
    }

}
