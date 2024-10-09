package org.example.answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Answer2 {
    public List<Integer> check(List<String> records) {
        var capacity = records.size();
        var pairs = new HashMap<Integer, Integer>(capacity);
        var auxNext = new HashSet<Integer>(capacity);
        var auxPrev = new HashSet<Integer>(capacity);
        var result = new ArrayList<Integer>(capacity);
        var pattern = Pattern.compile("(\\d+)(\\D+)(\\d+)");

        for (String s : records) {
            var matcher = pattern.matcher(s);
            if (!matcher.find()) throw new IllegalArgumentException(s);
            var next = Integer.valueOf(matcher.group(1));
            var prev = Integer.valueOf(matcher.group(3));
            pairs.put(next, prev);
            auxNext.add(next);
            auxPrev.add(prev);
        }
        auxNext.removeAll(auxPrev);

        var odd = auxNext.iterator().next();
        var even = pairs.remove(0);
        while (null != odd && 0 != odd) {
            result.add(odd);
            odd = pairs.remove(odd);
            if (null != even && 0 != even) {
                result.add(even);
                even = pairs.remove(even);
            }
        }

        return result;
    }
}
