package org.example.answers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer1 {
    public List<Integer> check(List<String> records){
        System.out.println(records);
        var resultArray = new int[records.size()];
        var recordsMap = new HashMap<Integer, Integer>();
        records.forEach(r -> {
            var parts = r.split(":");
            var firstPart = Integer.parseInt(parts[0]);
            var secondPart = Integer.parseInt(parts[1]);
            recordsMap.put(firstPart, secondPart);
        });

        for (var current : recordsMap.keySet()) {
            var index = getIndex(recordsMap, current, 0);
            if (index == null) continue;
            resultArray[index] = current;
        }
        resultArray[records.size() - 1] = getLastElementOrThrow(recordsMap);
        return Arrays.stream(resultArray).boxed().collect(Collectors.toList());
    }

    private Integer getLastElementOrThrow(Map<Integer, Integer> recordsMap) {
        return recordsMap.values().stream()
                .filter(val -> !recordsMap.containsKey(val))
                .findFirst()
                .orElseThrow();
    }

    private Integer getIndex(Map<Integer, Integer> recordsMap, Integer value, int index) {
        if (value == 0) {
            return null;
        }
        var v = recordsMap.get(value);
        if (v == null) {
            return recordsMap.size() - 1 - (2 * index);
        }
        if (v == 0) {
            return recordsMap.size() - 2 - (2 * index);
        }
        return getIndex(recordsMap, v, index + 1);
    }
}
