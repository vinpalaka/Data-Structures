package com.practice.sorting.dataobjects;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindBestReviewsUtil {

    /**
     * Sorts based on number of reviews descending. If both have same number of reviews, then sort them
     * ascending by id
     * @param newBusinesses
     * @param trendyBusiness
     * @return
     */
    public static List<NewBusiness> getBestReviews(List<NewBusiness> newBusinesses, List<NewBusiness> trendyBusiness) {
        newBusinesses.addAll(trendyBusiness);
        Comparator<NewBusiness> q = new Comparator<NewBusiness>() {
            @Override
            public int compare(NewBusiness o1, NewBusiness o2) {
                if(o2.numOfReviews == o1.numOfReviews) {
                    return o1.id - o2.id;
                }
                return o2.numOfReviews - o1.numOfReviews;
            }
        };
        Collections.sort(newBusinesses, q);

        return newBusinesses;
    }
}
