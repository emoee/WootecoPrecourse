package christmas;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputview = new InputView();
        OutputView outputView = new OutputView();
        Event event = new Event();

        int visit_date = inputview.readDate();
        Order menu_list = inputview.readMenu();

        List<String> evenList = event.checkEventAllow(menu_list, visit_date);
        
        outputView.allEvent(evenList);
    }
}
