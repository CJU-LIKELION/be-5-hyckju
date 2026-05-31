package class5.role;

import class5.policy.SubmissionPolicy;

// 모든 멤버(아기사자, 운영진)의 공통 속성을 모아둔 최상위 추상 클래스
public abstract class Role {
    // 캡슐화를 위해 필드들은 private으로 선언 (외부에서 직접 접근 불가)
    private String name;
    private String major;
    private String part;
    private String studentId;

    // 다형성을 활용하여 하위 클래스에서 각자의 Policy를 주입받아 사용 (protected로 하위 접근 허용)
    protected SubmissionPolicy policy;

    // 객체 생성 시 필수 정보들을 초기화하는 생성자
    public Role(String name, String major, String part, String studentId, SubmissionPolicy policy) {
        this.name = name;
        this.major = major;
        this.part = part;
        this.studentId = studentId;
        this.policy = policy;
    }

    // private 필드에 안전하게 접근하기 위한 Getter 메서드들
    public String getName() { return name; }
    public String getMajor() { return major; }
    public String getPart() { return part; }
    public String getStudentId() { return studentId; }

    // 하위 클래스(Lion, Staff)가 반드시 각자의 방식대로 구현해야 하는 추상 메서드들
    public abstract String getRoleName(); // "아기사자" 또는 "운영진" 문자열 반환
    public abstract String getShortInfo(); // 전체 조회 시 보여줄 짧은 요약 정보
    public abstract void printDetailInfo(); // 이름 검색 시 보여줄 상세 출력 로직
}
