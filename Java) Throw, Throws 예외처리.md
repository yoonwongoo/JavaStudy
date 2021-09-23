# Java) Throw, Throws 예외처리

### throw의 개념

##### throw란 ?

예외를 강제로 발생시키는 것이 바로 throw입니다.  

예를 들어 프로그래머가 강제로 "어느 한부분을 예외를 강제적으로 발생을 시켜야겠다" 하고  코딩을 하는 경우입니다.

즉,`throw`는 Exception을 발생시킬 때 사용하는 키워드.

**throw의 기본적인 형태**

```java
throw new 발생시킬예외 
```



간단한 예제를 들어서 봅니다.



**Calculator.java**


```java
public class Calculator {
public static int add(int x, int y) throws MyCustomException {

    int result = x + y;

    if (result > 100) {

        throw new MyCustomException();

    }
        return result;
}
```

위에 예제와 같이 간단하게 Calculator라는 클래스에 Int타입인 add의 메서드가 하나 있습니다.

보시다시피 더해서 result의 값이 100이 넘으면 throw를 사용해서 강제적으로 예외를 발생을 시킵니다.

result가 100이 넘지않으면 그대로 result를 반환을 해줍니다.

여기서 MyCustomException();은  Exception을 상속을 받아서 커스텀으로 만들어준 것입니다.





**MyCustomException.java**

```java
public class MyCustomException extends Exception{

    @Override
    public String getMessage() {
        return "100을 넘기면 안되는 경우.";
    }
}

```

getMessage()를 오버라이딩을 해줍니다.



그리고 Calculator.java에서 throws라는 것을 볼 수가 있는데, 

```java
public static int add(int x, int y) **throws** MyCustomException
```




##### throws란? 

영어 뜻 그대로 "던지다" 라는 의미를 가지고 있습니다.

여기서는 public static int add(int x, int y) 라는 메서드를 만들었는데, 이제 이 메서드를 사용하는 곳에서 예외를 처리해줘라. 즉 책임을 전가한다고 보시면 됩니다. 



**CalculatorMain.java**

```java
public class CalculatorMain {
public static void main(String[] args) {

    int result = 0;
    try {
        Calculator.add(123,123);
    } catch (MyCustomException e) {
    	e.getmessage();
    }   
  }
}
```

위에 코드를 보면 main이 Calculator의  add()함수를 사용을 하는데 throws 때문에 예외처리를 전가 받았기 때문에 처리를 해줘야 합니다.

그럴때는 try-catch문을 이용을 하여서, catch일때는 예외일 경우에 throw로 만든 예외를 처리를 해줍니다.

하지만 예외처리를 하나만 하는 것이 아니라  동시에 똑같은 예외처리를 하거나, 예외를 한 개 이상 처리를 할 수 있습니다.



예제를 더 추가해보자면,

**Calculator.java**

```java
 public class Calculator {
 	public static int add(int x, int y) throws MyCustomException, MyCustomException2 {

        int result = x + y;

        if (result > 100) {

            throw new MyCustomException();

        } else if (result < 0) {

            throw new MyCustomException2();
        } else
            return result;
    }

	/*추가된 sub메서드*/
    public static int sub(int x, int y) throws MyCustomException2 {
        int result = x - y;

        if (result < 0) {
            throw new MyCustomException2();//강제 예외발생.

        }
        return result;
    }
}
```



**MyCustomException2.java**

```java
public class MyCustomException2 extends Exception {
	/*추가된 예외*/
    @Override
    public String getMessage() {
        return "음수이면 안되는 경우.";
    }
}
```





**CalculatorMain.java**

```java
public class CalculatorMain {

    public static void main(String[] args){

        int result = 0;

        try {
            Calculator.sub(4,12);
            Calculator.add(123,123);
        } catch (MyCustomException e) {
            e.getMessage();//100을 넘기면 안되는 경우
        } catch (MyCustomException2 e) {
            e.getMessage();//음수가 되면 안되는 경우
        }

    }
}
```

위에 main을 보면, add()함수는 두가지의 예외를 처리를 해야합니다.

하지만 여기서 보면 sub()함수도 try-catch로 예외처리를 받아서 해줘야하는데, 그 예외처리를 해줘야하는 부분에서 add()와 동일한 예외처리를 하는부분이 있어서 같이 try안에 넣어줄 수 있습니다.

##### Multi catch

다음으로는 add()함수가 예외를 throws 2개 를 해주기 때문에 예외도 그에 맞게 처리를 해주기 때문에 catch도 2번을 해줘야 합니다.

```java
 catch (MyCustomException e) {
            e.getMessage();//100을 넘기면 안되는 경우
        } catch (MyCustomException2 e) {
            e.getMessage();//음수가 되면 안되는 경우
        }
```

또는

```java
 catch (MyCustomException | MyCustomException2 e) {
            e.getMessage();
        }//이렇게 비트논리연산자를 이용하여서 묶어서 할 수 있다.
```



또한 MyCustomException과 MyCustomException2의 예외인 경우 말고 또 다른 예외들은 일괄적으로 동일하게 처리하고 싶다고 하면 상위클래스 Exception이 모든 에러에 대해 가지고 있으니까 사용하여서 동일하게 처리해도 된다.

```java
catch (MyCustomException | MyCustomException2 e) {
            e.getMessage();
        } catch(Exception e){
            System.out.println("다시 입력을 해주세요");
        }
```



하지만 Exception이 범위가 더 크기 때문에 밑에 코드와 같은 경우는 안된다...

다른 많은 Exception들은 Exception클래스를 상속받아서 사용함.

```java
         catch(Exception e){
            System.out.println("다시 입력을 해주세요");
        }catch (MyCustomException | MyCustomException2 e) {
            e.getMessage();
        }
```





추가로 finally

**Calculator.java**

```java
public class CalculatorMain {

    public static void main(String[] args){

        int result = 0;

        try {
            Calculator.sub(4,1);//예외 안생김.
            Calculator.add(1,12);//예외 안생김.

        } catch (MyCustomException | MyCustomException2 e) {
            System.out.println("커스텀예외");
        } catch(Exception e){
            System.out.println("입력값에 오류가 있습니다.");
        }finally {
            System.out.println("다시 입력해주세요.");
        }

    }
}

```

예외가 없는경우에는 try에서 하고 빠져나오지만  아닌경우에는 catch로 예외를 처리하고, 추가로 들어온

finally는 무조건 try든 catch든 처리 후에 반드시 실행되는 부분이다.



**실행결과**

try부분에 처리 후 finally 실행

![qwqw](https://github.com/yoonwongoo/JavaStudy/blob/main/img/%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC1.PNG?raw=true)





catch부분에 처리 후 finally 실행

![](https://github.com/yoonwongoo/JavaStudy/blob/main/img/%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC2.PNG?raw=true)
