package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.ArrayList;
import java.util.List;

// 미리 정의된 더미(가짜) 데이터만 반환하는 저장소 구현체
// 실제 저장은 하지 않으므로, DB/저장 로직 없이도 Service·Main 동작을 테스트할 때 사용한다.
public class MockMemberRepository implements MemberRepository {
    private final List<Role> members = new ArrayList<>();

    public MockMemberRepository() {
        // 생성과 동시에 더미 멤버를 채워 둔다.
        members.add(new Lion("김멋사", "컴퓨터공학", 13, "백엔드", "20230001"));
        members.add(new Staff("이운영", "경영학", "파트장", "프론트엔드", "20210002"));
    }

    @Override
    public void save(Role role) {
        // Mock 저장소는 실제 저장을 하지 않는다. (더미 데이터만 제공)
        System.out.println("[Mock] 저장 요청은 무시됩니다 (실제 저장 X): " + role.getName());
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
