package com.practice.sorting.dataobjects;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given input of id value: sort based on value first
 * If value is number, then show those first in ascending order
 * then the words after also in ascending
 * If values are same, then sort by id
 */
public class SortLog {
    class Item  {
        String id;


        @Override
        public String toString() {
            return "Item{" +
                    "id='" + id + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }

        String value;

        public Item(String value) {
            this.id = id;
            this.value = value;
        }
        String x = Integer.toBinaryString(1);

        public String getId() {
            return id;
        }

        public String getValue() {
            return value;
        }



    }
    private boolean isDigit(String value) {
        String[] va = value.split(" ");
        for(String s : va) {
            if(s.matches("[0-9]+"))
                return true;
        }
        return false;
    }
    public List<Item> sortLogs(List<String> logs) {

        Comparator<Item> sortComp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(isDigit(o1.value)) {
                    if(isDigit(o2.value))  {
                        return -1;
                    } else {
                        return o1.value.compareTo(o2.value);
                    }
                }
                else {
                    if(isDigit(o2.value))  {
                        return o2.value.compareTo(o1.value);
                    } else {
                        o1.value.compareTo(o2.value);
                    }

                }
                return 0;
            }
        };

//        Comparator<Item> c = (o1, o2) -> {
//            if (o1.getValue().equals(o2.getValue())) {
//                return o1.id.compareTo(o2.id);
//            } else {
//                if (isDigit(o1.getValue())) {
//                    if (isDigit(o2.getValue())) {
//                        return o2.getValue().compareTo(o1.getValue());
//                    } else {
//                        return o1.compareTo(o2);
//                    }
//                } else {
//                    if (isDigit(o2.getValue())) {
//                        return o1.compareTo(o2);
//                    } else {
//                        return o1.getValue().compareTo(o2.getValue());
//                    }
//                }
//            }
//        };

        if(logs!= null) {
            return logs.stream()
                    .map(x -> new Item(x))
                    .sorted(sortComp)
                    .collect(Collectors.toList());

        }
        return null;
    }
}
