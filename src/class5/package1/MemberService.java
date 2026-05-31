package class5.package1;

import class5.role.Role;

import java.util.List;

// Step 1: 비즈니스 로직(이름 중복 검증 등)을 담당하는 서비스 레이어 (Service)
// ⚠️ Repository 구현체를 내부에서 직접 'new' 로 생성 → 강한 결합(Tight Coupling)
//    저장소를 다른 구현으로 바꾸려면 이 Service 코드를 직접 수정해야 한다.
public class MemberService {
    // Service 가 구현체(MemberRepository)를 직접 생성하고 그 클래스에 의존한다.
    private final MemberRepository repository = new MemberRepository();

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
