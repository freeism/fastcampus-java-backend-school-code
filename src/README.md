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


