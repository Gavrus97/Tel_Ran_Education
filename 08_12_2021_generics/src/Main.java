public class Main {

    public static void main(String[] args) {

        String str = (String)getItself("hello");
        String str3 = getItselfGenerified("Hello");
        Object number = getItself(1);


        Integer number2 = getItselfGenerified(1);



        GenerifiedClass<Integer> integerGenerifiedClass = new GenerifiedClass<>();

        int a = integerGenerifiedClass.getItself(1);

    }

    static Object getItself (Object o){
        return o;
    }

    static <T> T getItselfGenerified (T o){
        return o;
    }
}

class GenerifiedClass <T>{

    public T getItself(T o){
        return o;
    }
}
