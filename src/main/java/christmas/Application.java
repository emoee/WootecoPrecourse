package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputview = new InputView();
        Event event = new Event();

        int visit_date = inputview.readDate();
        Order menu_list = inputview.readMenu();

        event.christmas_Dday(menu_list, visit_date);


    }
}
