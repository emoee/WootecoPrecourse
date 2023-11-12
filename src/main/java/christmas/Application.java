package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputview = new InputView();
        inputview.readDate();
        Order menu_list = inputview.readMenu();
        System.out.println(menu_list.getMenuNames());
    }
}
