package class5.package1;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.List;
import java.util.Scanner;

// Step 1: 실행/입출력만 담당하는 UI 레이어 (Main)
// Repository 의 존재는 모른 채 오직 Service 에게만 일을 시킨다.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Service 가 내부에서 Repository 를 직접 생성하므로, Main 은 Service 만 만들면 된다.
        MemberService memberService = new MemberService();

        while (true) {
            System.out.println("\n====== 멤버 관리 시스템 (Step 1) ======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    registerMember(scanner, memberService);
                    break;
                case 2:
                    printAllMembers(memberService);
                    break;
                case 3:
                    searchMember(scanner, memberService);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }

    // 멤버 등록: 입력을 받아 Role 객체를 만든 뒤 Service 에 위임한다.
    private static void registerMember(Scanner scanner, MemberService memberService) {
        System.out.println("\n--- 멤버 등록 ---");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int roleType = Integer.parseInt(scanner.nextLine());

        System.out.print("이름: ");
        String name = scanner.nextLine();

        Role member;
        if (roleType == 1) { // 아기사자
            System.out.print("전공: ");
            String major = scanner.nextLine();
            System.out.print("기수: ");
            int generation = Integer.parseInt(scanner.nextLine());
            System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
            String part = scanner.nextLine();
            System.out.print("학번: ");
            String studentId = scanner.nextLine();
            member = new Lion(name, major, generation, part, studentId);
        } else if (roleType == 2) { // 운영진
            System.out.print("전공: ");
            String major = scanner.nextLine();
            System.out.print("직책 (예: 13기, 파트장): ");
            String position = scanner.nextLine();
            System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
            String part = scanner.nextLine();
            System.out.print("학번: ");
            String studentId = scanner.nextLine();
            member = new Staff(name, major, position, part, studentId);
        } else {
            System.out.println("잘못된 역할 선택입니다.");
            return;
        }

        // 중복 검증은 Service 가 담당. 실패 시 예외로 알려준다.
        try {
            memberService.register(member);
            System.out.println("등록 완료: " + name);
        } catch (IllegalArgumentException e) {
            System.out.println("등록 실패: " + e.getMessage());
        }
    }

    // 전체 멤버 조회
    private static void printAllMembers(MemberService memberService) {
        System.out.println("\n--- 전체 멤버 목록 ---");
        List<Role> members = memberService.getAllMembers();
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        int index = 1;
        for (Role member : members) {
            System.out.println(index + ". " + member.getShortInfo());
            index++;
        }
        System.out.println("총 " + members.size() + "명");
    }

    // 이름으로 검색
    private static void searchMember(Scanner scanner, MemberService memberService) {
        System.out.println("\n--- 이름으로 검색 ---");
        System.out.print("검색할 이름: ");
        String searchName = scanner.nextLine();
        System.out.println();

        Role member = memberService.searchByName(searchName);
        if (member != null) {
            System.out.println("[검색 결과]");
            member.printDetailInfo();
        } else {
            System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
        }
    }
}
