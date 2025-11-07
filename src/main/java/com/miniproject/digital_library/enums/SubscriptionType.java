package com.miniproject.digital_library.enums;

public enum SubscriptionType {
    NOT_SUBSCRIBED("Not Subscribed",0),
    PLUS("Plus",3),
    PRO("Pro",7),
    PREMIUM("Premium",12);

    private String name;
    private int bookLimit;

    SubscriptionType(String name,int bookLimit) {
        this.name = name;
        this.bookLimit = bookLimit;
    }

    public int getBookLimit() {
        return bookLimit;
    }
}
