package class5.role;

import class5.policy.LionSubmissionPolicy;

// Role 추상 클래스를 상속받는 아기사자 클래스
public class Lion extends Role {
    private int generation;

    // 아기사자 객체를 생성할 때 호출되는 생성자
    public Lion(String name, String major, int generation, String part, String studentId) {
        // super()를 통해 부모(Role) 클래스의 생성자 호출. 이때 아기사자 전용 Policy 객체를 생성해서 넘겨줌!
        super(name, major, part, studentId, new LionSubmissionPolicy());
        this.generation = generation;
    }
    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getShortInfo() {
        // 부모의 getName()과 자신의 generation을 조합하여 요약 문자열 생성
        return "[" + getRoleName() + "] " + getName() + " - " + generation + "기";
    }

    @Override
    public void printDetailInfo() {
        System.out.println("역할: " + getRoleName());
        System.out.println("이름: " + getName() + " | 전공: " + getMajor() + " | 기수: " + generation + " | 파트: " + getPart());
        System.out.println("학번: " + getStudentId());
        // policy 객체가 무엇이든 상관없이 getSubmissionStatus()를 부르기만 하면 알아서 올바른 결과(가능)가 나옴 (다형성)
        System.out.println("과제 제출 가능 여부: " + policy.getSubmissionStatus());
    }
}
