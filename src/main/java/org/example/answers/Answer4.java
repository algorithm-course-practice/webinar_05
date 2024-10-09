package org.example.answers;


import java.util.Arrays;
import java.util.List;

public class Answer4 {
    public List<Integer> check(List<String> records){
        int recordsSize = records.size();
        Integer[] a = new Integer[recordsSize];
        Integer[] b = new Integer[recordsSize];
        Integer[] c = new Integer[recordsSize];
        Arrays.fill(c, 0);
        List<Integer> result = Arrays.asList(c);

        for(int i = 0; i < recordsSize; i++) {
            String currentRecord = records.get(i);
            String[] splitedRecord = currentRecord.split(":");
            a[i] = Integer.valueOf(splitedRecord[0]);
            b[i] = Integer.valueOf(splitedRecord[1]);
            if(a[i] == 0) {
                result.set(1, b[i]);
            }
            if(b[i] == 0) {
                result.set(recordsSize - 2, a[i]);
            }

        }

        for(int i = 0; i < records.size(); i++) {
            if(result.contains(a[i]) && b[i] != 0 && a[i] != 0) {
                result.set(result.indexOf(a[i]) + 2, b[i]);
            }
            if(result.contains(b[i]) && a[i] != 0 && b[i] != 0) {
                result.set(result.indexOf(b[i]) - 2 , a[i]);
            }

        }

        return result;
    }
}
