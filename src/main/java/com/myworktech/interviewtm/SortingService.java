package com.myworktech.interviewtm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingService {

    public String sortAccordingToAlphabet(String input, List<Character> alphabet) {
        Map<Character, Integer> occurrenceOfCharMap = new HashMap<>();
        StringBuilder resultStringBuilder = new StringBuilder();
        for (char inputChar : input.toCharArray()) {
            occurrenceOfCharMap.compute(inputChar, (keyChar, valueOccurrences) -> {
                if (valueOccurrences == null) {
                    return 1;
                } else {
                    return valueOccurrences + 1;
                }
            });
        }

        for (Character aChar : alphabet) {
            Integer charOccurrences = occurrenceOfCharMap.get(aChar);

            if (charOccurrences != null) {
                resultStringBuilder.append(String.valueOf(aChar).repeat(charOccurrences));
                occurrenceOfCharMap.remove(aChar);
            }
        }

        occurrenceOfCharMap.forEach((key, value) -> resultStringBuilder.append(String.valueOf(key).repeat(value)));

        return resultStringBuilder.toString();
    }
}
