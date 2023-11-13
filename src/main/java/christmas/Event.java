package christmas;

// - [ ] 크리스마스 디데이 할인
//     - [ ] 이벤트 기간 확인 ( 12.1 ~ 12.25 )
//     - [ ] 할인 금액 계산 
// ( e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인 )
    
public class Event {
    public void christmas_Dday(Order menu_list, int visit_date){
        int total = 0;

        if (CheckDate(visit_date) == "christmas"){
            for (String menuName : menu_list.getMenuNames()) {
            
                Menu selectedMenu = getMenuByName(menuName);
            if (selectedMenu != null) {
                total += selectedMenu.getPrice();
            }
        }
            System.out.println(total);
        }
    }

    private String CheckDate(int visit_date){
        String event_type = "";
        if (visit_date > 0 && visit_date < 26){
            event_type = "christmas";
        }
        else if (visit_date > 0  && visit_date < 32){
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
