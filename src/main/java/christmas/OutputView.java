package christmas;

import java.util.List;

public class OutputView {
    private static final String CHRISTMAS_EVENT_NAME = "christmas";
    private static final String GIFT_EVENT_NAME = "giftEvent";
    private static final String SPECIAL_EVENT_NAME = "specialDiscount";
    private static final String EVENT_NOT_ALLOWED_MESSAGE = "이벤트 불가";
    private static final String WEEKDAY_EVENT_MESSAGE = "평일 할인";
    private static final String WEEKEND_EVENT_MESSAGE = "주말 할인";


    public void allEvent(List<String> eventList, Order menuList, int visitDate){
        printOrderMenu(menuList, visitDate);
        printOrderAmount(eventList.get(0));
        printGift(eventList);

        
        if (!eventList.contains(EVENT_NOT_ALLOWED_MESSAGE)){
            discountEvent(eventList);
        }
    }

    private void discountEvent(List<String> eventList){
        System.out.println("");
        System.out.println("<혜택 내역>");
        
        if (eventList.contains(CHRISTMAS_EVENT_NAME)){
            int christmasIndex = eventList.indexOf(CHRISTMAS_EVENT_NAME)+1;
            printChristmasDday(Integer.parseInt(eventList.get(christmasIndex)));
        }
        if (eventList.contains(WEEKDAY_EVENT_MESSAGE)){
            int dayIndex = eventList.indexOf(WEEKDAY_EVENT_MESSAGE)+1;
            printWeekday(Integer.parseInt(eventList.get(dayIndex)));
        }
        if (eventList.contains(WEEKEND_EVENT_MESSAGE)){
            int dayIndex = eventList.indexOf(WEEKEND_EVENT_MESSAGE)+1;
            printWeekend(Integer.parseInt(eventList.get(dayIndex)));
        }
        if (eventList.contains(SPECIAL_EVENT_NAME)){
            int dayIndex = eventList.indexOf(SPECIAL_EVENT_NAME)+1;
            printSpecial(Integer.parseInt(eventList.get(dayIndex)));
        }
    }

    private void printGift(List<String> eventList){
        System.out.println("");
        System.out.println("<증정 메뉴>");

        String giftname = "없음";

        if (eventList.contains(GIFT_EVENT_NAME)) {
            int index = eventList.indexOf(GIFT_EVENT_NAME) + 1;
            if (index < eventList.size() && eventList.get(index).equals("샴페인")) {
                giftname = eventList.get(index) + " 1개";
            }
        }
        System.out.println(giftname);
    }

    private void printSpecial(int total){
        String formattedTotal = String.format("%,d", total);
        System.out.println("특별 할인: -" + formattedTotal + "원");
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
        System.out.println("");
        System.out.println("<할인 전 총주문 금액>");
        double total = Double.parseDouble(totalString);
        String formattedTotal = String.format("%,.0f", total);
        System.out.println(formattedTotal + "원");
    }

    private void printChristmasDday(int total){
        String formattedTotal = String.format("%,d", total);
        System.out.println("크리스마스 디데이 할인: -" + formattedTotal + "원");
    }

    private void printWeekday(int total){
        String formattedTotal = String.format("%,d", total);
        System.out.println("평일 할인: -" + formattedTotal + "원");
    }

    private void printWeekend(int total){
        String formattedTotal = String.format("%,d", total);
        System.out.println("주말 할인: -" + formattedTotal + "원");
    }
}
