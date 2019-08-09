package com.example.myapplication2907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;


abstract public class Calculate {

    private final static List<String> religion = Arrays.asList("атеист", "католик", "протестант",
            "православный", "язычник", "мусульманин", "буддист", "агностик", "пастфарианин", "иудей");

    static List<Integer> totalAnswer =
            new ArrayList<Integer>(Collections.nCopies(religion.size(), 0));

    static List<Integer> sum(List<Integer> first, List<Integer> second) {
        List<Integer> sum = new ArrayList<Integer>(Collections.nCopies(first.size(), 0));
        for (int i = 0; i < first.size(); i++) {
            sum.set(i, first.get(i) + second.get(i));
        }
        return sum;

    }

    static String firstReligion(List<Integer> vector) {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        for (int i = 0; i < religion.size(); i++) {
            result.put(vector.get(i), religion.get(i));
        }
        return result.get(result.lastKey());
    }

    public static Integer percentReligion(List<Integer> vector) {
        TreeMap<Integer, String> result = new TreeMap<Integer, String>();
        Integer sumOfVector = 0;
        for (int i = 0; i < religion.size(); i++) {
            result.put(vector.get(i), religion.get(i));
            sumOfVector += vector.get(i);
        }
        return result.lastKey() * 100 / sumOfVector;
    }
}
