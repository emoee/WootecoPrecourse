package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int readDate() {
        int visit_date;

        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            try {
                visit_date = Integer.parseInt(Console.readLine());
                if (visit_date >= 1 && visit_date <= 31) {
                    break; 
                }
                System.out.println("[ERROR] 1 이상 31 이하의 숫자로만 입력해 주세요.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return visit_date;
    }

    public Order readMenu() {
        String[] menuList;

        while (true) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine().trim();
            menuList = input.split(",");

            try {
                validateMenu(menuList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return setMenu(menuList);
    }

    private void validateMenu(String[] menuList) {
        for (String menu : menuList) {
            String menuName = menu.split("-")[0];
            try {
                Menu selectedMenu = Menu.valueOf(menuName);

                if (!menu.matches("[가-힣]+-\\d{1,2}")) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        if (calculateTotal(menuList) > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }
    

    private Order setMenu(String[] menuList){
        List<String> menuNames = new ArrayList<>();
        List<Integer> menuCounts = new ArrayList<>();

        for (int i = 0; i < menuList.length; i++) {
            menuNames.add(menuList[i].split("-")[0]);
            menuCounts.add(Integer.parseInt(menuList[i].split("-")[1]));
        }
        return new Order(menuNames, menuCounts);
    }

    private int calculateTotal(String[] menuList) {
        int total = 0;

        for (String menu : menuList) {
            try {
                int count = Integer.parseInt(menu.split("-")[1]);
                total += count;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 주문 개수는 숫자로 입력해 주세요. 다시 입력해 주세요.");
            }
        }
        return total;
    }
}
