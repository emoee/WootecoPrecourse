package christmas;

import java.util.List;

public class OutputView {
    private static final String EVENT_NOT_ALLOWED_MESSAGE = "이벤트 불가";

    public void allEvent(List<String> eventList, Order menuList, int visitDate){
        EventResult eventResult = new EventResult(eventList);

        printOrderMenu(menuList, visitDate);
        printOrderAmount(eventList.get(0));
        printGift(eventResult.resultGift());
        discountEvent(eventResult);
        printEventTotal(eventResult.getEventTotal());
        printFinalAmount(eventResult.getOrderTotal());
        printBadge(eventResult.getBadge());
    }

    private void discountEvent(EventResult eventResult){
        System.out.println("");
        System.out.println("<혜택 내역>");

        if (eventResult.getEventList().contains(EVENT_NOT_ALLOWED_MESSAGE)){
            System.out.println("없음");
            return;
        }
        printChristmasDday(eventResult.resultChristmas());
        printWeekday(eventResult.resultWeekday());
        printWeekend(eventResult.resultWeekend());
        printSpecial(eventResult.resultSpecial());      
        printGiftPrice(eventResult.resultGiftPrice());
    }

    private void printEventTotal(int total){
        String formattedTotal = String.format("%,d", total);

        if (total > 0 ){
            formattedTotal = ("-" + formattedTotal);
        }
        System.out.println("");
        System.out.println("<총혜택 금액>");
        System.out.println(formattedTotal + "원");
    }

    private void printBadge(String badge){
        System.out.println("");
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    private void printFinalAmount(int total){
        String formattedTotal = String.format("%,d", total);

        System.out.println("");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formattedTotal + "원");
    }

    private void printGift(String gift){
        System.out.println("");
        System.out.println("<증정 메뉴>");
        System.out.println(gift);
    }

    private void printGiftPrice(int total){
        if (total > 0){
            String formattedTotal = String.format("%,d", total);
            System.out.println("증정 이벤트: -" + formattedTotal + "원");
        }
    }

    private void printSpecial(int total){
        if (total > 0){
            String formattedTotal = String.format("%,d", total);
            System.out.println("특별 할인: -" + formattedTotal + "원");
        }
    }

    private void printOrderMenu(Order menuList, int visitDate){
        System.out.println("12월" + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("");
        System.out.println("<주문 메뉴>");

        for (int i = 0; i < menuList.getMenuNames().size(); i++) {
            String menuName = menuList.getMenuNames().get(i);
            int menuCount = menuList.getMenuCounts().get(i);
            
            System.out.println(menuName + " " + menuCount + "개");
        }
    }

    private void printOrderAmount(String totalString){
        double total = Double.parseDouble(totalString);
        String formattedTotal = String.format("%,.0f", total);

        System.out.println("");
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formattedTotal + "원");
    }

    private void printChristmasDday(int total){
        if (total > 0){
            String formattedTotal = String.format("%,d", total);
            System.out.println("크리스마스 디데이 할인: -" + formattedTotal + "원");
        }
    }

    private void printWeekday(int total){
        if (total > 0){
            String formattedTotal = String.format("%,d", total);
            System.out.println("평일 할인: -" + formattedTotal + "원");
        }
    }

    private void printWeekend(int total){
        if (total > 0){
            String formattedTotal = String.format("%,d", total);
            System.out.println("주말 할인: -" + formattedTotal + "원");
        }
    }
}
