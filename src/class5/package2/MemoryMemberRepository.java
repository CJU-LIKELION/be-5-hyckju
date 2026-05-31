package class5.package2;

import class5.role.Role;

import java.util.ArrayList;
import java.util.List;

// 실제 데이터를 메모리(List)에 저장하는 저장소 구현체
public class MemoryMemberRepository implements MemberRepository {
    private final List<Role> members = new ArrayList<>();

    @Override
    public void save(Role role) {
        members.add(role);
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
