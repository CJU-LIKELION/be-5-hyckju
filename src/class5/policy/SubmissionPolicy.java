package class5.policy;

// 과제 제출 원칙을 정의하는 인터페이스 (다형성을 위한 뼈대)
public interface SubmissionPolicy {
    // 제출 가능 여부를 문자열로 반환하도록 강제하는 추상 메서드
    String getSubmissionStatus();
}
