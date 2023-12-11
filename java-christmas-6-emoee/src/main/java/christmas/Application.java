package christmas;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputview = new InputView();
        OutputView outputView = new OutputView();
        Event event = new Event();

        int visitDate = inputview.readDate();
        Order menuList = inputview.readMenu();
        List<String> eventList = event.checkEventAllow(menuList, visitDate);
        
        outputView.allEvent(eventList, menuList, visitDate);
    }
}
