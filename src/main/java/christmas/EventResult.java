package christmas;

import java.util.List;

public class EventResult {
    private List<String> eventList;
    private int eventTotal;

    private static final String CHRISTMAS_EVENT_NAME = "christmas";
    private static final String GIFT_EVENT_NAME = "giftEvent";
    private static final String SPECIAL_EVENT_NAME = "specialDiscount";
    private static final String WEEKDAY_EVENT_MESSAGE = "평일 할인";
    private static final String WEEKEND_EVENT_MESSAGE = "주말 할인";

    public EventResult(List<String> eventList){
        this.eventList = eventList;
        this.eventTotal = 0;
    }

    public List<String> getEventList(){
        return eventList;
    }

    public int getEventTotal(){
        return eventTotal;
    }

    public int resultChristmas(){
        int result = 0;
        if (eventList.contains(CHRISTMAS_EVENT_NAME)){
            int christmasIndex = eventList.indexOf(CHRISTMAS_EVENT_NAME)+1;
            result = Integer.parseInt(eventList.get(christmasIndex));
        }
        this.eventTotal += result;
        return result;
    }

    public int resultWeekday(){
        int result = 0;
        if (eventList.contains(WEEKDAY_EVENT_MESSAGE)){
            int dayIndex = eventList.indexOf(WEEKDAY_EVENT_MESSAGE)+1;
            result = Integer.parseInt(eventList.get(dayIndex));
        }
        this.eventTotal += result;
        return result;
    }

    public int resultWeekend(){
        int result = 0;
        if (eventList.contains(WEEKEND_EVENT_MESSAGE)){
            int dayIndex = eventList.indexOf(WEEKEND_EVENT_MESSAGE)+1;
            result = Integer.parseInt(eventList.get(dayIndex));
        }
        this.eventTotal += result;
        return result;
    }

    public int resultSpecial(){
        int result = 0;
        if (eventList.contains(SPECIAL_EVENT_NAME)){
            int dayIndex = eventList.indexOf(SPECIAL_EVENT_NAME)+1;
            result = Integer.parseInt(eventList.get(dayIndex));
        }
        this.eventTotal += result;
        return result;
    }
    
    public String resultGift(){
        String giftname = " ";
        if (eventList.contains(GIFT_EVENT_NAME)) {
            int index = eventList.indexOf(GIFT_EVENT_NAME) + 1;
            if (index < eventList.size() && eventList.get(index).equals("샴페인")) {
                giftname = eventList.get(index) + " 1개";
            }
        }
        return giftname;
    }

    public int resultGiftPrice(){
        int result = 0;
        if (eventList.contains(GIFT_EVENT_NAME)){
            int dayIndex = eventList.indexOf(GIFT_EVENT_NAME)+2;
            result = Integer.parseInt(eventList.get(dayIndex));
        }
        this.eventTotal += result;
        return result;
    }
}
