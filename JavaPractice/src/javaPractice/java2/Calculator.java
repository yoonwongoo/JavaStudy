package javaPractice.java2;

public class Calculator {

    public static int add(int x, int y) throws MyCustomException, MyCustomException2 {

        int result = x+y;

        if (result >100) {

            throw new MyCustomException();

        } else if (result < 0) {

            throw new MyCustomException2();
        }
            return result;
    }


    public static int sub(int x, int y) throws MyCustomException2 {
        int result = x-y;

        if (result < 0) {
            throw new MyCustomException2();

        }
        return result;
    }
}
