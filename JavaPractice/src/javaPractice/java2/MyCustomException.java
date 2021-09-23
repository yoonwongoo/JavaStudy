package javaPractice.java2;

class MyCustomException extends Exception{

    @Override
    public String getMessage() {
        return "100을 넘기면 안되는 경우.";
    }
}
