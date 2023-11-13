package christmas;

import java.util.List;

public class OutputView {
    public void allEvent(List<String> eventList, Order menuList, int visitDate){
        printOrderMenu(menuList, visitDate);
        printOrderAmount(eventList.get(0));
        
        if (!eventList.contains("이벤트 불가")){
            discountEvent(eventList);
        }
    }

    private void discountEvent(List<String> eventList){
        System.out.println("");
        System.out.println("<혜택 내역>");
        
        if (eventList.contains("christmas")){
            int christmasIndex = eventList.indexOf("christmas")+1;
            printChristmasDday(Integer.parseInt(eventList.get(christmasIndex)));
        }
        if (eventList.contains("평일 할인")){
            int dayIndex = eventList.indexOf("평일 할인")+1;
            printWeekday(Integer.parseInt(eventList.get(dayIndex)));
        }
        if (eventList.contains("주말 할인")){
            int dayIndex = eventList.indexOf("주말 할인")+1;
            printWeekend(Integer.parseInt(eventList.get(dayIndex)));
        }
        if (eventList.contains("specialDiscount")){
            int dayIndex = eventList.indexOf("specialDiscount")+1;
            printSpecial(Integer.parseInt(eventList.get(dayIndex)));
        }
        
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
