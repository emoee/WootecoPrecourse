package christmas;

public enum Menu {
    양송이수프("양송이수프", 6000, Category.애피타이저),
    타파스("타파스", 5500, Category.애피타이저),
    시저샐러드("시저샐러드", 8000, Category.애피타이저),

    티본스테이크("티본스테이크", 55000, Category.메인),
    바비큐립("바비큐립", 54000, Category.메인),
    해산물파스타("해산물파스타", 35000, Category.메인),
    크리스마스파스타("크리스마스파스타", 25000, Category.메인),

    초코케이크("초코케이크", 15000, Category.디저트),
    아이스크림("아이스크림", 5000, Category.디저트),

    제로콜라("제로콜라", 3000, Category.음료),
    레드와인("레드와인", 60000, Category.음료),
    샴페인("샴페인", 25000, Category.음료);

    private final String name;
    private final int price;
    private final Category category;

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
    
    public enum Category {
        애피타이저, 메인, 디저트, 음료
    }
}

