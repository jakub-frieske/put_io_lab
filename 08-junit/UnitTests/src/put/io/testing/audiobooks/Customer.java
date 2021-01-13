package put.io.testing.audiobooks;

public class Customer {
    public enum LoyaltyLevel {
        STANDARD, SILVER, GOLD
    }

    private String name;
    private LoyaltyLevel loyaltyLevel;
    private boolean isSubscriber;

    public Customer(String name, LoyaltyLevel loyaltyLevel, boolean isSubscriber) {
        this.name = name;
        this.loyaltyLevel = loyaltyLevel;
        this.isSubscriber = isSubscriber;
    }

    public String getName() {
        return name;
    }

    public LoyaltyLevel getLoyaltyLevel() {
        return loyaltyLevel;
    }

    public boolean isSubscriber() {
        return isSubscriber;
    }
}
