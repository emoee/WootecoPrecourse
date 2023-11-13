package christmas;

import java.util.List;

public class OutputView {
    public void allEvent(List<String> eventList){
        if (!eventList.contains("이벤트 불가")){
            if (eventList.contains("christmas")){
                int christmasIndex = eventList.indexOf("christmas")+1;
                printChristmasDday(Integer.parseInt(eventList.get(christmasIndex)));
            }
        }
    }

    private void printChristmasDday(int total){
        String formattedTotal = String.format("%,d", total);
        System.out.println("크리스마스 디데이 할인: -" + formattedTotal + "원");
    }
}
