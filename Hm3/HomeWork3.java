package ru.hm;

import java.util.*;

public class HomeWork3 {
    PhoneBook pb = new PhoneBook();

    public static void main(String[] args) {
        String[] words = {
                "стол", "стул", "кресло", "кровать",
                "гитара", "стул", "телефон", "чайник",
                "кровать", "ванна", "дверь", "стол",
                "стул", "чайник"};
        List<String> data = Arrays.asList(words);
        Set<String> set = new TreeSet<>(data);
        System.out.println(data);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for (String word : data) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        map.forEach((word, count) -> {
            System.out.println(word + " = " + count);
        });
    }
}
