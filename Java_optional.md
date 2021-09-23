# Java_optional

### Optional이란?



NPE를 해결하기 위해 코드들이 지저분해지고 로직이 복잡해지는 경우가 빈번합니다.

그러한 문제점을 해결하기 위해 나온 WrapperClass입니다**.**



**Optional**<T>

```java
public final class Optional<T> extends Object
```

final로 지정된 class이므로 더 이상의 확장은 할 수가 없다.



OptionalClass에는 여러가지 메서드가 있지만 그 중에서 많이 사용하는 메서드를 보겠습니다.





**empty()**

```java
Optional<String> op = Optional.empty();//OptinalType의 빈 객체 생성.
```

Optin













