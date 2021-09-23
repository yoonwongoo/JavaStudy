# Java	Generic 



### Generic이란?

JDK1.5에 처음으로 제네릭이 도입되었습니다.

제네릭은 클래스의 타입을 지정해줄때, 외부에서 클래스의 타입을 지정해주는 방법(?)입니다.



제네릭이 왜 나왔을까? 그이유는 유연하며, 빈번하게 자주 타입변환 시 생기는 프로그램의 성능저하를 초래하기 때문에 나왔습니다.



예를 들어봅니다.



Closet (옷장이라는 클래스(한개의 종류의 옷을 넣을 수 있는 옷장이라고 가정.)

옷장에 넣을 수 있는 옷의 종류는 Pants와 Jacket가 있습니다.(더 많이 있을 수 있음.)



```java
public class Jacket {
    @Override
    public String toString() {
        return "자켓입니다.";
    }
}
```





```java
public class Pants {

    public String toString(){

        return "바지입니다";
    }

}

```



```java
public class ClosetOne {
    private Jacket clothes;

    public Jacket getClothes() {
        return clothes;
    }

    public void setClothes(Jacket clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "자켓1입니다";
    }
}
```





```java
public class ClosetTwo {

    private Pants clothes;

    public Pants getClothes() {
        return clothes;
    }

    public void setClothes(Pants clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "바지1입니다";
    }
}
```



**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Jacket jacket = new Jacket();
        ClosetOne one = new ClosetOne();
        one.setClothes(jacket);
        one.getClothes();



        Pants pants = new Pants();
        ClosetTwo two = new ClosetTwo();
        two.setClothes(pants);
        two.getClothes();

    }
}
```





이렇게 위에 코드와 같이 하나의 옷장에 하나의 옷종류를 넣을 수 있습니다.

하지만 하나의 옷장에 여러개의 옷을 넣을 수 있다면, 지금의 경우는 종류가 2가지라 짧지만 100개,1000개가 넘어갈 경우에는..곤란합니다. 추가적으로는  getter,setter를 남발하는 경우가 생깁니다.



그래서 이런 경우에는 예전에 제네릭이 도입 되기 전에는 최상위 클래스인 Object 로 getter, setter를 지정해주면 된다..

```java
public class ClosetOne {
    private Object clothes;

    public Object getClothes() {
        return clothes;
    }

    public void setClothes(Object clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "자켓1입니다";
    }
}

public class ClosetTwo {

    private Object clothes;

    public Object getClothes() {
        return clothes;
    }

    public void setClothes(Object clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "바지1입니다";
    }
}
```





하지만 이렇게 할 경우에는 형변환이라고.. 계속 해줘야한다... 쓸때 없이..

**Main.java**

```java
     Jacket jacket = new Jacket();
     ClosetOne one = new ClosetOne();
     one.setClothes(jacket);
     Jacket j = (Jacket) one.getClothes();
```



그래서 여러가지로 필요성을 느껴서 제네릭이 도입 된 거 같습니다.

제네릭의 형식은 기본적으로 

class Ex<T> ,  interface<T>  등 선언 시 "<>" 을 붙이면서 안에 타입파라미터를 지정 해 줍니다.

```java
class className<K, V,...>
interface interfaceName<K, V,...>
```



타입파라미터의 종류는 타입을 나타내는<T>와  요소를 나타내는 <E>과 "Key":"Value"인 <K, V>

등의 두가지 이상의 파라미터를 받을 수 있습니다.

추가로 관용적으로 알파벳에 의미를 부여하여서 사용을 합니다. 굳이 이렇게 형식을 따르지 않고 자신이  원하는 파라미터를  넣어도 됩니다. 



| 타입인자 | 설명    |
| -------- | ------- |
| <T>      | Type    |
| <E>      | Element |
| <K>      | Key     |
| <N>      | Number  |
| <V>      | Value   |
| <R>      | Result  |





그럼 제네릭을 이용해봅시다.

기본적인 틀은 같지만 제네릭을 이용한 것만 다른 점이 있는 클래스입니다.

```java
public class GClosetThree<T> {

    private T clothes;

    public T getClothes() {
        return clothes;
    }

    public void setClothes(T clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return cloth.toString();
    }
}
```



**Main.java**

```java
 Pants pants = new Pants();
        Jacket jacket = new Jacket();


        GClosetThree<Pants> GPants= new GClosetThree<Pants>();
        GPants.setClothes(pants);
        GPants.getClothes();//형변환이 일어나지않음.

        GClosetThree<Jacket> GJacket = new GClosetThree<Jacket>();
        GJacket.setClothes(jacket);
        GJacket.getClothes();//형변환이 일어나지않음.
    }
```

위에 코드와 같이 타입파라미터에 맞게 이루어지게 때문에  형변환이 필요없습니다.

그러고 Closet클래스를 옷의 종류별로 만들 필요도 없습니다.

코드의 길이도 줄이며, 유연하게 동적으로 사용할 수 있습니다.







### Generic<T extends Class >

<T extends Class> 란  T의 자료형의 범위를 제한적으로 받을 수 있습니다.

예를 들면 아까 위에서 코딩한 것처럼 옷의 종류만 Closet으로 set을 해줘야하는데, 

제한이 없기 때문에 무분별하게 여러타입의 클래스를 받을 수 있습니다.

상속을 받지 않은 타입의 자료형은 Object타입의 자료형으로 변환이 되므로 Object타입의 기본적인 메소드를 사용할 수 있습니다.

이러한 것을 방지하기위해 상속을 받을 타입만 받을 수 있게 제한을 줍니다.





```java
public class Clothes{
    
}
//Pants, JacketClass가 상속받을 Class.




public class Pants extends Clothes {

    public String toString(){

        return "바지입니다";
    }
    
    
    
    
public class Jacket extends Clothes{
    @Override
    public String toString() {
        return "자켓입니다.";
    }
```

이렇게 위의 처럼 상속을 받으면서 원하는 타입의 자료형만을 제한을 두면서 할 수 있습니다.



지금은 아무것도 없지만, 상속을 받을 타입이 추상형으로 오버라이딩을 해야 하는 경우면 오버라이딩도 당연히 해줘야 합니다.



```java
public abstract class Clothes {

    public abstract void printClothes(); 
}




public class Jacket extends Clothes{
    @Override
    public String toString() {
        return "자켓입니다.";
    }

    @Override
    public void printClothes() {
        System.out.println("자켓을 출력합니다");
    }//부모 오버라이딩
}



public class Pants extends Clothes {

    public String toString(){

        return "바지입니다";
    }

    @Override
    public void printClothes() {
        System.out.println("바지를 출력합니다.");
    }//부모 오버라이딩
}
```



즉, 제네릭을 사용하는이유를 정리해보자면,



- **비슷하거나 동일한 기능을 재사용을 할 수 있다.(재사용성)**
- **형변환(Type Casting)의 번거러움 및 성능저하 방지할 수 있다.**
- **제네릭을 사용시에 미리 잘못된 타입(자료형)에 대해 방지할 수 있다.(컴파일 시 미리 타입체크.)**





[Java Generic 공부예제](https://github.com/yoonwongoo/JavaStudy/tree/main/JavaPractice/src/javaPractice/java3)

