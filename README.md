# 레이어드 아키텍쳐

spring boot application 동일 패키지 내부에 패키지는 도메인 기준으로 분리될 예정입니다.
(ex : order, product, member 등등)

# 레이어 진행 순서
presentation  -> application -> infrastructure 로 볼 수 있습니다.
의존 방향은 단방향이 바람직합니다.
왜냐하면 application 이 presentation 을 알게 되거나, infrastructure 이 application 등 을 알게 되면 결합도가 올라가게 되고, 관심사의 분리를 못하게 됩니다. 또 양방향으로 개발하게 되면, 순환 참조의 문제가 발생하게 될 수 있기 때문에 되도록이면 지양합니다.
ex ) dto 를 서비스에서 사용하기보다, dto 를 command, query 등 service 내부에서 사용하는 어떤 클래스로 변환하여 service 에 전달. 이렇게 하면 service 는 외부 통신에 신경 쓰지 않고 비즈니스 로직에만 집중하면 됩니다.

# 레이어 별 역할
application 은 business process 에 집중하고, presentation 은 클라이언트와의 통신, infrastructure 은 서버 외부의 기술적인 측면의 통신을 담당합니다 db 등등

# 주입
스프링 내부 컴포넌트 간 주입은 생성자 주입 방식 (private final, @RequiredArgsConstructor), interface 로 주입합니다.

주입 방식은 세가지가 있는데, 생성자 주입 방식을 spring 에서 권장합니다.
생성자 방식의 경우 생성자가 하나밖에 없는 경우 spring 에서는 @autowired를 생략할 수 있습니다. 생성자 방식이 왜 권장되는지는 찾아보시는걸 권장드립니다.

interface 로 주입하는 경우 (이를 solid 중 dip 라고 볼 수 있습니다) 코드의 변경이 필요할 때 interface는 내버려두고, implements 와 component 만 잘 붙여주면 injection 이 진행되기 때문에 그 컴포넌트를 의존하는 클래스의 변경은 필요없어지고, 기능이 확장될 수 있습니다. (이는 solid 중 ocp 라고 볼 수 있습니다.) 따라서 interface 로 주입하는 것이 타당합니다.

# db 의 추상화
예시 코드 내부의 service 에서 OrderJpaRepository 를 의존하게 하는 것이 아니라, reader 와 store 로 분리한 바 있습니다. 이는 service 코드가 특정 기술에 의존하지 못하도록 추상화에 의존하는 것인데, 이 역시도 Dip 라고 할 수 있습니다.

이를 분리하는 이유는, 저희가 jpa 로 개발을 하다 보면 한계를 느끼는 지점이 분명 있을 텐데, 이 때 querydsl 나 mybatis 등 동적 쿼리를 사용해야하거나, jdbc 등을 활용해서 native query 를 활용해야 하는 경우가 생길 수 있습니다. 만약 서비스가 그 모든 기술을 알게되면 어떨까요? 서비스가 매우 뚱뚱해지고 기술 의존도가 매우 높아지며 (결합도 올라감) 나중에 변경이 필요하면 유지보수하기가 매우 힘들어집니다. 그렇기 때문에, 기술의 경우를 추상화 하는 것입니다.
