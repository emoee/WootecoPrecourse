package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private static final String CHRISTMAS_EVENT_NAME = "christmas";
    private static final String GIFT_EVENT_NAME = "giftEvent";
    private static final String SPECIAL_EVENT_NAME = "specialDiscount";
    private static final String EVENT_NOT_ALLOWED_MESSAGE = "이벤트 불가";
    private static final String WEEKDAY_EVENT_MESSAGE = "평일 할인";
    private static final String WEEKEND_EVENT_MESSAGE = "주말 할인";

    private static final int GIFT_ELIGIBILITY_THRESHOLD = 120000;

    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private static final int WEEK_DISCOUNT_AMOUNT = 2023;


    public List<String> checkEventAllow(Order menuList, int visitDate){
        List<String> eventList = new ArrayList<>();
        int total = calculateTotal(menuList);
        eventList.add(String.valueOf(total));

        if (total < 10000 || onlyDrinks(menuList)){
            eventList.add(EVENT_NOT_ALLOWED_MESSAGE);
        }

        eventList.addAll(christmas_Dday(menuList, visitDate));
        eventList.addAll(weekday(menuList, visitDate));
        eventList.addAll(weekend(menuList, visitDate));
        eventList.addAll(specialDiscount(menuList, visitDate));
        eventList.addAll(giftEvent(menuList, visitDate));

        return eventList;
    }

    private List<String> giftEvent(Order menuList, int visitDate) {
        List<String> events = new ArrayList<>();
        int giftprice = 0;
        int total = calculateTotal(menuList);

        events.add(GIFT_EVENT_NAME);

        if (total > GIFT_ELIGIBILITY_THRESHOLD){
            giftprice = 25000;
            events.add("샴페인");
            events.add(String.valueOf(giftprice));
        }
        return events;
    }

    private List<String> specialDiscount(Order menuList, int visitDate) {
        List<String> events = new ArrayList<>();
        int discount = 0;

        if (isSpecialDiscountPeriod(visitDate)) {
            discount = SPECIAL_DISCOUNT_AMOUNT;
        }
        events.add(SPECIAL_EVENT_NAME);
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
        if (checkDate(visitDate).equals(CHRISTMAS_EVENT_NAME)){
            discount = calculateChristmasDiscount(visitDate);
        }
        events.add(CHRISTMAS_EVENT_NAME);
        events.add(String.valueOf(discount));
        return events;
    }

    private List<String> weekday(Order menuList, int visitDate) {
        return generateEvent(menuList, visitDate, Menu.Category.디저트, WEEKDAY_EVENT_MESSAGE);
    }
    
    private List<String> weekend(Order menuList, int visitDate) {
        return generateEvent(menuList, visitDate, Menu.Category.메인, WEEKEND_EVENT_MESSAGE);
    }

    private List<String> generateEvent(Order menuList, int visitDate, Menu.Category category, String eventName) {
        List<String> events = new ArrayList<>();
        int discount = calculateDiscount(menuList, visitDate, category);
        
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
            total = itemCount * WEEK_DISCOUNT_AMOUNT;
        }

        if (isWeekend(visitDate) && category == Menu.Category.메인) {
            total = itemCount * WEEK_DISCOUNT_AMOUNT;
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
            event_type = CHRISTMAS_EVENT_NAME;
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
