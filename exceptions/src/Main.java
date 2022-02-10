public class Main {

    public static void main(String[] args) {
        System.out.println(divide(10,3));//3
        try{
            int res = divideManualExceptionWrapper(10,0);
            System.out.println(res);
            System.out.println("Code after division");
        }catch (CustomArithmeticException | ArithmeticException e) {
            System.out.println("Caught CustomArithmeticException ");
        } catch (RuntimeException e) {
            System.out.println("inside runtime exception");
        }
//        } catch (ArithmeticException e){
//            System.out.println("Caught ArithmeticException");
//        }
        System.out.println(divide(10,2));//5
    }

    /**
     * return yhe result by dividing a over b
     *
     * @param a
     * @param b
     * @return
     */
    public static int divide (int a, int b){
        return a/b;
    }

    public static int divideManualExceptionWrapper (int a, int b) {
        return divideManualException(a,b);
    }

    public static int divideManualException (int a, int b) {
        if (b == 0)
            throw new CustomArithmeticException();
        return a/b;
    }
}
