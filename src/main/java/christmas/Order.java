package christmas;

import java.util.List;

public class Order {
    private List<String> menuNames;
    private List<Integer> menuCounts;

    public Order(List<String> menuNames, List<Integer> menuCounts) {
        this.menuNames = menuNames;
        this.menuCounts = menuCounts;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public List<Integer> getMenuCounts() {
        return menuCounts;
    }
}
