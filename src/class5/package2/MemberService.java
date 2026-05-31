package class5.package2;

import class5.role.Role;

import java.util.List;

// Step 2: 비즈니스 로직(이름 중복 검증 등)을 담당하는 서비스 레이어 (Service)
// ✅ 오직 MemberRepository '인터페이스'에만 의존한다.
// ✅ 내부에서 'new' 로 구현체를 만들지 않고, 외부에서 생성자로 주입(DI)받는다.
public class MemberService {
    // 주입받은 의존성은 한 번 설정되면 바뀌지 않도록 final 로 선언 (불변성 유지)
    private final MemberRepository repository;

    // 생성자 주입(Constructor Injection): 어떤 구현체를 쓸지는 Service 가 정하지 않는다.
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 멤버 등록: 이름 중복을 검증한 뒤 저장한다. (검증은 '이름 중복'만)
    public void register(Role role) {
        if (repository.existsByName(role.getName())) {
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }
        repository.save(role);
    }

    // 전체 멤버 조회
    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    // 이름으로 멤버 검색 (없으면 null)
    public Role searchByName(String name) {
        return repository.findByName(name);
    }
}
