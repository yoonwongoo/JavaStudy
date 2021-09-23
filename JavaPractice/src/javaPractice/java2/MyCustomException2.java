package javaPractice.java2;

public class MyCustomException2 extends Exception {
    @Override
    public String getMessage() {
        return "음수이면 안되는 경우.";
    }
}
