package class5.package1;

import class5.role.Role;

import java.util.ArrayList;
import java.util.List;

// Step 1: 멤버 데이터의 저장/조회만 책임지는 저장소 레이어 (Repository)
// 비즈니스 로직(중복 검증 등)은 알지 못하고, 순수하게 데이터 보관만 담당한다.
public class MemberRepository {
    // 실제 데이터를 메모리에 보관하는 리스트
    private final List<Role> members = new ArrayList<>();

    // 멤버 한 명을 저장
    public void save(Role role) {
        members.add(role);
    }

    // 전체 멤버 조회
    public List<Role> findAll() {
        return members;
    }

    // 이름으로 멤버 한 명을 조회 (없으면 null)
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    // 해당 이름의 멤버가 이미 존재하는지 여부
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
