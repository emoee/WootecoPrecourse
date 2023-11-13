package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
    public List<String> checkEventAllow(Order menuList, int visitDate){
        List<String> eventList = new ArrayList<>();
        int total = calculateTotal(menuList);
        eventList.add(String.valueOf(total));

        if (total < 10000 || onlyDrinks(menuList)){
            eventList.add("이벤트 불가");
        }

        eventList.addAll(christmas_Dday(menuList, visitDate));
        eventList.addAll(weekday(menuList, visitDate));
        eventList.addAll(weekend(menuList, visitDate));
        eventList.addAll(specialDiscount(menuList, visitDate));

        return eventList;
    }

    private List<String> specialDiscount(Order menuList, int visitDate) {
        List<String> events = new ArrayList<>();
        int discount = 0;
        if (isSpecialDiscountPeriod(visitDate)) {
            discount = 1000;
        }
        
        events.add("specialDiscount");
        events.add(String.valueOf(discount));

        return events;
    }

    private boolean isSpecialDiscountPeriod(int visitDate){
        LocalDate date = LocalDate.of(2023, 12, visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (visitDate == 25 || dayOfWeek.getValue() == 7){
            return true;
        }
        return false;
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

    private List<String> weekday(Order menuList, int visitDate) {
        return generateEvent(menuList, visitDate, Menu.Category.디저트, "평일 할인");
    }
    
    private List<String> weekend(Order menuList, int visitDate) {
        return generateEvent(menuList, visitDate, Menu.Category.메인, "주말 할인");
    }

    private List<String> generateEvent(Order menuList, int visitDate, Menu.Category category, String eventName) {
        List<String> events = new ArrayList<>();
        int discount = discount = calculateDiscount(menuList, visitDate, category);
        
        if (discount > 0) {
            events.add(eventName);
            events.add(String.valueOf(discount));
        }
        return events;
    }

    private int calculateDiscount(Order menuList, int visitDate, Menu.Category category) {
        int total = 0;
        int itemCount = countCategory(menuList, category);
    
        if (isWeekday(visitDate) && category == Menu.Category.디저트) {
            total = itemCount * 2023;
        }

        if (isWeekend(visitDate) && category == Menu.Category.메인) {
            total = itemCount * 2023;
        }
    
        return total;
    }

    private boolean isWeekday(int visitDate) {
        LocalDate date = LocalDate.of(2023, 12, visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getValue() >= 1 && dayOfWeek.getValue() <= 4 || dayOfWeek.getValue() == 7;
    }
    
    private boolean isWeekend(int visitDate) {
        LocalDate date = LocalDate.of(2023, 12, visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        return dayOfWeek.getValue() >= 5 && dayOfWeek.getValue() <= 6;
    }

    private int countCategory(Order menuList, Menu.Category category) {
        int categoryCount = 0;
    
        for (String menuName : menuList.getMenuNames()) {
            Menu selectedMenu = getMenuByName(menuName);
    
            if (selectedMenu != null && selectedMenu.getCategory() == category) {
                categoryCount += menuList.getMenuCounts().get(menuList.getMenuNames().indexOf(menuName));
            }
        }
        return categoryCount;
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
