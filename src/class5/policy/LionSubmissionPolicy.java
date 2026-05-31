package class5.policy;

// 아기사자의 과제 제출 규칙을 구현하는 클래스
public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public String getSubmissionStatus() {
        return "가능"; // 아기사자는 과제 제출 의무가 있음
    }
}
