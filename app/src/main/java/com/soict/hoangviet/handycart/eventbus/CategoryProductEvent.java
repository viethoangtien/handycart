package com.soict.hoangviet.handycart.eventbus;

public class CategoryProductEvent {
    private boolean isFirst;

    public CategoryProductEvent(boolean isFirst) {
        this.isFirst = isFirst;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }
}
