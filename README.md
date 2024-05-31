# Spring - @Transactional Test

### 테스트 환경

- Parent
- Child

## @Transactional(propagation = REQUIRES_NEW)의 오해

### 테스트 방법

> ParentService.save() = `@Transactional`  
> ChildService.save() = `@Transactional(propagation = REQUIRES_NEW)`

1. ParentService.save() 메서드를 호출
2. ParentRepository -> Parent Entity 저장
3. ParentService.save() 메서드에서 ChildService.save() 메서드를 호출한다.
4. ChildRepository -> Child Entity 저장
5. ChildService.save() 메서드에서 IllegalStateException 발생

### 테스트 결과

- ParentService 트랜잭션과 ChildService의 트랜잭션은 별도의 트랜잭션은 맞다.
- 하지만, **동일 스레드**에서 각각의 트랜잭션(커넥션도 별도)을 사용!
- 이러한 경우, ChildService의 트랜잭션에서 예외가 발생하면, 상위의 ParentService의 트랜잭션이 롤백이 되는 문제가 발생함.
- 따라서 ChildService의 트랜잭션에서 예외가 발생한 경우를 처리해줘야 함.

ex. try-catch 문을 사용,,

## @Transactional(readOnly = true)의 오해

@Transactional(readOnly = true) 옵션을 주고, save를 호출한다면?

### 테스트 방법

- ParentService - @Transactional(readOnly = true) 옵션 설정
- ParentRepository.save() 호출

### 테스트 결과

- 에러가 발생하지 않음.
- 또한, ParentRepository.count() 호출 시 저장된 것을 확인할 수 있음.
- JpaRepository의 save() 메서드는 SimpleJpaRepository의 save() 메서드를 호출

_SimpleJpaRepository - save_
![readOnly.png](img/readOnly.png)

- 위의 코드를 보면 `@Transaction` 어노테이션이 별도로 설정되어있는 것을 볼 수 있음.
- 따라서, `@Transactional(readOnly = true)` 옵션을 주더라도, `save()` 메서드는 `@Transactional` 옵션을 따르게 됨.

## @Transactional - Isolation

```java
package org.springframework.transaction.annotation;

import org.springframework.transaction.TransactionDefinition;

public enum Isolation {

    DEFAULT(TransactionDefinition.ISOLATION_DEFAULT),

    READ_UNCOMMITTED(TransactionDefinition.ISOLATION_READ_UNCOMMITTED),

    READ_COMMITTED(TransactionDefinition.ISOLATION_READ_COMMITTED),

    REPEATABLE_READ(TransactionDefinition.ISOLATION_REPEATABLE_READ),

    SERIALIZABLE(TransactionDefinition.ISOLATION_SERIALIZABLE);

    private final int value;


    Isolation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}

```

# JPA - N+1

> N+1이 @OneToOne 관계에서도 발생한다?

### 읽어보기

- [Spring boot :: JPA에서 OneToOne 관계 N+1 문제 정리](https://wave1994.tistory.com/156)
- [OneToOne 관계는 과연 지연로딩이 되는가?](https://velog.io/@yhlee9753/OneToOne-%EA%B4%80%EA%B3%84%EB%8A%94-%EA%B3%BC%EC%97%B0-%EC%A7%80%EC%97%B0%EB%A1%9C%EB%94%A9%EC%9D%B4-%EB%90%98%EB%8A%94%EA%B0%80)
- [JPA @OneToOne은 FetchType.LAZY가 안 먹힐 수 있다?](https://jeong-pro.tistory.com/249)

## 원인

- `@OneToOne` 관계의 Default FetchType은 EAGER
- But, LAZY로 설정해주어도 EAGER로 동작하는 예외적인 상황이 발생
- 단방향 `@OneToOne` 관계에서는 문제가 없지만, **양방향** @OneToOne 관계에서는 무조건 EAGER로 동작한다.

> _정확히 얘기하자면_  
> OneToOne 양방향 연관 관계에서 연관 관계 주인이 아닌 엔티티를 조회할 때, LAZY 전략이 무시되고 EAGER 전략으로 동작한다.

## 이유

![JPA_Proxy.png](img/JPA_Proxy.png)

- fetchType.LAZY로 동작하기 위해서는 JPA 구현체에서 `Proxy` 를 만들어 줘야 한다.
- 또한, JPA 구현체는 연관 관계 Entity에 **Null** 또는 **프록시 객체**가 할당되어야 한다.

_아래는 테이블의 구조_

![locker_member.png](img/locker_member.png)

- locker 테이블 컬럼에 Member에 관한 정보가 존재하지 않는다.
- 따라서, Member Entity에 대한 정보가 없는 상태에서 `@OneToOne` 양방향 관계인 상태
- 이러한 상황에서 Member Entity를 조회하게 되면, JPA 구현체는 Member Entity에 대한 정보가 없기 때문에 **프록시 객체**를 만들어 줄 수 없다.

