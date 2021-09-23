package javaPractice.java2;

public class CalculatorMain {

    public static void main(String[] args){

        int result = 0;

        try {
            Calculator.sub(4,6);//예외 생김.
            Calculator.add(1,100);//예외 생김.

        } catch (MyCustomException | MyCustomException2 e) {
            System.out.println("커스텀예외");
        } catch(Exception e){
            System.out.println("입력값에 오류가 있습니다.");
        }finally {
            System.out.println("다시 입력해주세요.");
        }

    }


}
