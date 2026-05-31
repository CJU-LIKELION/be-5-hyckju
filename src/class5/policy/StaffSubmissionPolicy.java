package class5.policy;

// 운영진의 과제 제출 규칙을 구현하는 클래스
public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public String getSubmissionStatus() {
        return "불가능"; // 운영진은 과제 제출 의무가 없음
    }
}
