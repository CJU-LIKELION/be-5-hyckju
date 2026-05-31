package class5.role;

import class5.policy.StaffSubmissionPolicy;

// Role 추상 클래스를 상속받는 운영진 클래스
public class Staff extends Role {
    private String position; // 운영진만의 고유 속성 (직책)

    public Staff(String name, String major, String position, String part, String studentId) {
        // 운영진 전용 Policy 객체를 부모 생성자에 전달
        super(name, major, part, studentId, new StaffSubmissionPolicy());
        this.position = position;
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getShortInfo() {
        return "[" + getRoleName() + "] " + getName() + " - " + position;
    }

    @Override
    public void printDetailInfo() {
        System.out.println("역할: " + getRoleName());
        System.out.println("이름: " + getName() + " | 전공: " + getMajor() + " | 직책: " + position + " | 파트: " + getPart());
        System.out.println("학번: " + getStudentId());
        // 운영진의 Policy이므로 알아서 "불가능" 이 출력됨
        System.out.println("과제 제출 가능 여부: " + policy.getSubmissionStatus());
    }
}
