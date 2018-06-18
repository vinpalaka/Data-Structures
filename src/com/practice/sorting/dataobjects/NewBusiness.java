package com.practice.sorting.dataobjects;

public class NewBusiness {
    int id;
    int numOfReviews;

    @Override
    public String toString() {
        return "NewBusiness{" +
                "id=" + id +
                ", numOfReviews=" + numOfReviews +
                '}';
    }

    public NewBusiness(int id, int numOfReviews) {
        this.id = id;
        this.numOfReviews = numOfReviews;
    }
}
