package com.example.myapplication2907;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Calculate {

    public final static List<String> religion = Arrays.asList("атеист", "католик", "протестант",
            "православный", "язычник", "мусульманин", "буддист", "агностик", "пастфарианин", "иудей");

    public static String firstReligion(List<Integer> vector) {
        Map<Integer,String> result=new TreeMap<Integer,String>();
        for (int i=0;i<religion.size();i++){
            result.put(vector.get(i),religion.get(i));
        }
        return result.get(((TreeMap<Integer, String>) result).lastKey());
    }

    public static Integer percentReligion(List<Integer> vector) {
        Map<Integer, String> result = new TreeMap<Integer, String>();
        Integer sumOfVector = 0;
        for (int i = 0; i < religion.size(); i++) {
            result.put(vector.get(i), religion.get(i));
            sumOfVector += vector.get(i);
        }
        return ((TreeMap<Integer, String>) result).lastKey()*100/sumOfVector;
    }
}
