A : 송금 `(A계좌 돈을 차감 -> SLEEP(commit x) -> B계좌 돈을 추가)`
B : 수령

BTS공연티켓 예매<- 엄청난 트랜잭션  (100장 예매 -> 92장) <- C사 : 물건 100개 -> 102개
숙박 D업체 (12/24 신라호텔 스위트룸 3개 -> 4개)
1 - 별개의 트랜잭션 : A-iphone : 송금 submit
2 - 별개의 트랜잭션 : A-atm : 출금 submit (1에서 차감된 금액(read_uncommitted) - 출금금액)
or (원래금액(read_committed) - 출금금액)
: 조회시점에 따라서 금액이 바뀌게 됨
repeatable_read : read lock
serializable : write lock (ACID)

Transaction => DB 연산 명령어의 묶음
All or Nothing -> commit or rollback
Transaction -> 이커머스, 숙박예박 -> 쿠폰사용여부, 결제성공여부, 숙박업소예약여부
"insert(user) -> update(login) -> insert(user_history)"
"insert(상대방계좌) -> update(내계좌)"
ACID Rule -> DRY : Do not Repeat Yourself. :: SOLID
Atomicity : 원자성 -> 부분성공이 있으면 안됨 (송금 -> 내 통장 돈이 나갔는데, 상대방x)
Consistency : 일관성 -> DB에 있는 contraint조건들 다 만족시킴(송금했는데 성공, 내 통장 -50000)
Isolation : 독립성 -> 데이터조작에 자유로워야함 (송금하고 있는중에, 상대방 돈 빼감)
Durability : 지속성 -> 데이터가 영구적 보관 (송금했고, 성공했음 -> 다음날 돈x)

# 1/6
mvn : compile testCompile
gradle : 
    compileJava : com.fastcampus.todo.controller.HelloWorldController.class
    compileTestJava : com.fastcampus.todo.controller.HelloWorldController.class, HelloWorldControllerTest.class

@MockBean
- 선언된 클래스를 Mock으로 만들어서, Bean으로 올려줌

@Bean vs @Component
- @Component : class scope
- @Bean : method scope

Lock
- 배타적 독점권한
- Tomcat - request serving -> thread
- DB - request serving -> connection 
- tx1 : A, B, C
- tx2 : C, D, A
- 교착상태 (DeadLock)


Service <- ?????? 스펙정의가 필요

- TDD -> Test Driven Development
- BDD -> Behavior Driven Development
- DDD -> Domain Driven Development
  // User -> 유저를 가입시키는 것(기존) : public void join(User user);
  //      -> 유저가 가입을 하는 것 (DDD) : user.join();

- service 역할
    - 비지니스(스펙, 정책) 로직의 처리
    - 트랜잭션 관리
        - PaymentController - PaymentRepository
        - 카드결제를 추가함
          - CardPaymentController - (Card)PaymentRepository
        - 카카오페이를 추가함
          - Kakao ...
        - 토스를 추가함
          - Toss ...
        - 무통장입금
          - ...
        - 쿠폰 -> 100원미만 쿠폰(x)
        - 할인
    - 중복코드의 추상화
        - PaymentService
    - summary
        - 확장성
        - 재사용성
    
- Service Layer Test
    - Controller/Repository Test 좀 달라요.
    - SpringBoot 테스트
        - 장점 
            - 실제로 돌아가는 것들 볼 수 있음.
            - 처음 테스트를 만들 때, 쉬움.
        - 단점
            - Spring Context 로딩이 오래 걸림
            - 데이터, 상태같은 것들이 서비스간에 간섭을 일으킴
            - 세밀한 테스트가 불가능함
                - 이상한 시스템 문자열 <- 테스트방법(x)
    - Mock 테스트의 장점
        - 실행속도 빠름
        - 테스트간 영향이 적어요
        - 정밀한 테스트 가능
    
- Controller 
  -> SpringBootTest (<- 메소드를 호출)
  -> MockMvcTest (o) -> httpRequest중요
  -> MockTest
- Service
  -> SpringBootTest
  -> MockTest (o)
- Repository
  -> SpringBootTest (o) -> SQL동작
  -> MockTest

* 테스트원칙
    * F - Fast <- 2가지 중의적의미 (테스트를 하는것 자체가 빨라야된다, 테스트가 빨라야된다)
    * I - Independent
    * R - Repeatable
    * S - Self Validating
    * T - Timely
    * https://tanzu.vmware.com/application-modernization-recipes/testing/spring-boot-testing-best-practices

// 아까 any 안에 온 User.class의미가 User인가요 ? 
extends User 인가요 2.self-validation의미 한번만 말해주세요



// UML <- Entity 설계
http://www.yes24.com/Product/Goods/4492519

```java
class User {
    @OneToMany
    List<Todo> todos;
}

class UserService {
    @Transactional
    public User getUser(Long userId) {
        return userRepository.findById(userId);
    }
}

class UserController {
    public List<Todo> getTodos(Long userId) {
        return userService.getUser(userId).getTodos();
    }
}
```

예외처리 (Exception)
- 오류 -> 실제로 런닝하는 시스템에서 별개로 처리하고 싶은 것
- Throwable
    - Error
        - 시스템에 대한 오류 (JVM)
        - 개발자가 관리할 영역(x)  
    - Exception
        - 구현한 로직의 문제점을 체크
        - 개발자가 꼭 핸들링 해야 되는 영역
        - CheckedException
            - 예외처리를 강제하고 있음
            - 처리하지 않으면 컴파일오류
            - method signature -> throw Exception (안좋은습관)
        - UncheckedException
            - Runtime에 확인되는 오류
            - RuntimeException
        -> 한 때 논란 : 통일 UncheckedException -> RuntimeException
              
* try - catch - finally

```java
class Test {
    public void test() {
        try {
            doSomething();
        } catch (TypeConstraintException e1) {
            doExceptionSomething();
        } catch (NullPointerException e2) {
            doExceptionSomething();
        }
    }
}
```

```java
class Test {
    public void test() {
        try {
            doSomething();
        } catch (TypeConstraintException | NullPointerException e) {
            doExceptionSomething();
        }
    }
}
```

```java
import java.io.BufferedInputStream;

class Test {
    public void test() {
        try (BufferedInputStream bis = new BufferedInputStream()) {
            // ...
        }
    }
}
```

* AOP
    * Aspect-Oriented Programming
    * 관점지향 프로그래밍
 관점(관심)   
----------|-------
   -> User|Service ->
----------|-------
    -> Ord|erService ->
----------|--------
    -> Pay|mentService ->
----------|--------
          |
      
* AOP를 사용하는 것 
    * 로그.. ??
    
* AOP를 사용했을 때 장점
    * 어플리케이션 전체에 흩어진 공통 기능을 하나의 로직으로 관리 
    * 각 로직들은 자신의 로직에 충실하면 됨 (SRP)
    
* AOP 용어
    * Target : 해당 기능을 적용할 대상 클래스를 의미함
    * Aspect : 해당 로직의 관심밖에 있는 어떠한 기능을 추가로 제공함
    * Advice : Aspect의 기능 구현체, 언제/무엇을 할지 결정
    * Pointcut : 적용될 타겟의 어떤 위치(?)
    * JoinPoint : advice가 실행되는 위치 
