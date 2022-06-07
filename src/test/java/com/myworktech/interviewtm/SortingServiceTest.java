package com.myworktech.interviewtm;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SortingServiceTest {

    private SortingService sortingService = new SortingService();

    @Test
    public void sortAccordingToAlphabet_all_symbols_present() {
        String actual = sortingService.sortAccordingToAlphabet("bacaed", List.of('a', 'b', 'c', 'd', 'e'));
        assertEquals("aabcde", actual);
    }

    @Test
    public void sortAccordingToAlphabet_not_all_symbols_from_alphabet_present_in_input() {
        String input = "abacabax";
        String actual = sortingService.sortAccordingToAlphabet(input, List.of('x', 'b', 'f'));
        assertEquals("xbbaaaac", actual);
        Assertions.assertThat(actual)
                .startsWith("xbb")
                .containsPattern("[ac]+")
                .hasSameSizeAs(input);
    }

    @Test
    public void sortAccordingToAlphabet_not_all_symbols_from_input_present_in_alphabet() {
        String input = "abcdfeefdcba";
        String actual = sortingService.sortAccordingToAlphabet(input, List.of('a', 'b', 'c'));
        assertEquals("aabbccddeeff", actual);
        Assertions.assertThat(actual)
                .startsWith("aabbcc")
                .containsPattern("[d-f]+")
                .hasSameSizeAs(input);
    }

    @Test
    public void sortAccordingToAlphabet_empty_alphabet() {
        String input = "abcdfeefdcba";
        String actual = sortingService.sortAccordingToAlphabet(input, List.of());
        Assertions.assertThat(actual)
                .containsPattern(Pattern.compile("[a-e]+"))
                .hasSameSizeAs(input);
    }

    @Test
    public void sortAccordingToAlphabet_empty_input() {
        String actual = sortingService.sortAccordingToAlphabet("", List.of('a'));
        Assertions.assertThat(actual)
                .isEqualTo("");
    }
}
