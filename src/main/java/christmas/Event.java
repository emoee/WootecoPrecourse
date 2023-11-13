package christmas;

import java.util.ArrayList;
import java.util.List;

public class Event {

    public List<String> checkEventAllow(Order menuList, int visitDate){
        List<String> eventList = new ArrayList<>();
        int total = calculateTotal(menuList);

        if (total < 10000 || onlyDrinks(menuList)){
            eventList.add("이벤트 불가");
        }

        eventList.addAll(christmas_Dday(menuList, visitDate));

        return eventList;
    }

    private List<String> christmas_Dday(Order menuList, int visitDate){
        List<String> events = new ArrayList<>();
        int discount = 0;
        if (checkDate(visitDate).equals("christmas")){
            discount = calculateChristmasDiscount(visitDate);
        }
        events.add("christmas");
        events.add(String.valueOf(discount));
        return events;
    }

    private boolean onlyDrinks(Order menuList){
        boolean hasNonDrink = true;
        for (String menuName : menuList.getMenuNames()){
            Menu selectedMenu = getMenuByName(menuName);
            if (selectedMenu != null && selectedMenu.getCategory() != Menu.Category.음료){
                hasNonDrink = false;
            }
        }
        return hasNonDrink;
    }

    private int calculateTotal(Order menuList){
        int total = 0;
        List<String> menuNames = menuList.getMenuNames();
        List<Integer> menuCounts = menuList.getMenuCounts();

        for (int i = 0; i < menuNames.size(); i++) {
            String menuName = menuNames.get(i);
            int menuCount = menuCounts.get(i);
            
            Menu selectedMenu = getMenuByName(menuName);

            if (selectedMenu != null) {
                total += selectedMenu.getPrice() * menuCount;
            }
        }
        return total;
    }

    private int calculateChristmasDiscount(int visitDate){
        int discount = 1000 + (visitDate - 1) * 100;
        return discount > 3400 ? 3400 : discount;
    }

    private String checkDate(int visitDate){
        String event_type = "";
        if (visitDate > 0 && visitDate < 26){
            event_type = "christmas";
        }
        else if (visitDate > 0  && visitDate < 32){
            event_type = "December";
        }

        return event_type;
    }

    private Menu getMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return menu;
            }
        }
        return null;
    }
}
