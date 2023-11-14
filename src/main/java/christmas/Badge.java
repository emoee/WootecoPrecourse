package christmas;

public enum Badge {
    STAR(5000, "별"),
    TREE(10000, "트리"),
    SANTA(20000, "산타");

    private final int threshold;
    private final String name;

    Badge(int threshold, String name) {
        this.threshold = threshold;
        this.name = name;
    }

    public static Badge getBadgeForTotal(int total) {
        for (int i = values().length - 1; i >= 0; i--) {
            Badge badge = values()[i];
            if (total >= badge.threshold) {
                return badge;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
