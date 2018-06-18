package com.practice.sorting.dataobjects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindBestReviewsUtilTest {

    @Test
    public void getBestReviews() {
        List<NewBusiness> first = new ArrayList<>();
        first.add(new NewBusiness(1, 10));
        first.add(new NewBusiness(2, 20));
        first.add(new NewBusiness(3, 200));
        first.add(new NewBusiness(4, 100));
        first.add(new NewBusiness(5, 60));
        first.add(new NewBusiness(6, 20));

        List<NewBusiness> second = new ArrayList<>();
        second.add(new NewBusiness(7, 45));
        second.add(new NewBusiness(8, 305));
        second.add(new NewBusiness(9, 5));
        second.add(new NewBusiness(10, 65));
        second.add(new NewBusiness(11, 1005));
        second.add(new NewBusiness(12, 25));

        FindBestReviewsUtil.getBestReviews(first, second).forEach(System.out::println);

    }

    @Test
    public void getSmallBestReviews() {
        List<NewBusiness> first = new ArrayList<>();
        first.add(new NewBusiness(1, 200));


        List<NewBusiness> second = new ArrayList<>();
        second.add(new NewBusiness(7, 100));


        FindBestReviewsUtil.getBestReviews(first, second).forEach(System.out::println);

    }
}