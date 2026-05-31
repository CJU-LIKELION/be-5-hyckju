package class5.package2;

import class5.role.Role;

import java.util.List;

// Step 2: 저장소의 '규격(역할)'만 정의하는 인터페이스 (추상화)
// Service 는 구현 클래스가 아닌 이 인터페이스에만 의존한다. → 느슨한 결합(Loose Coupling)
public interface MemberRepository {
    void save(Role role);

    List<Role> findAll();

    Role findByName(String name);

    boolean existsByName(String name);
}
