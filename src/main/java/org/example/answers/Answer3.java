package org.example.answers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer3 {
    public List<Integer> check(List<String> records) {
        //для числа a на позиции i в очереди храним числа на позициях i - 2, i + 2
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();

        for (String s : records) {
            String[] parts = s.split(":");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            Pair<Integer, Integer> entryA = map.getOrDefault(a, new Pair<>(null, null));
            entryA.setSecond(b);
            map.put(a, entryA);

            Pair<Integer, Integer> entryB = map.getOrDefault(b, new Pair<>(null, null));
            entryB.setFirst(b);
            map.put(b, entryB);
        }

        int n = records.size();
        Integer[] result = new Integer[n];

        //число, у которого first=null, является первым в очереди
        Integer curr = map.entrySet()
                .stream()
                .filter(x -> x.getValue().first == null)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();

        //заполняем нечетные позиции
        for (int i = 0; i < n; i += 2) {
            result[i] = curr;
            curr = map.get(curr).second;
        }

        //число, у которого предыдущее(first) = 0, является вторым в очереди
        //заполняем четные позиции
        curr = map.get(0).second;
        for (int i = 1; i < n; i += 2) {
            result[i] = curr;
            curr = map.get(curr).second;
        }

        return Arrays.asList(result);
    }

    @AllArgsConstructor
    @Setter
    @Getter
    @ToString
    public static class Pair<T1, T2> {
        private T1 first;
        private T2 second;
    }
}
