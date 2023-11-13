package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int visit_date = Integer.parseInt(Console.readLine());

        return visit_date;
    }

    public Order readMenu() {
        String[] menuList;
        do {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine().trim();
            menuList = input.split(",");

            if (calculateTotal(menuList) > 20) {
                System.out.println("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해주세요.");
            }
        } while (calculateTotal(menuList) > 20);

        return setMenu(menuList);
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
            int count = Integer.parseInt(menu.split("-")[1]);
            total += count;
        }
        return total;
    }
}
