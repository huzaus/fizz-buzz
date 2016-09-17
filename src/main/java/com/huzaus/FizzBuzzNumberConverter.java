package com.huzaus;

import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;

public class FizzBuzzNumberConverter implements NumberConverter {

    private List<Function<Integer, String>> functions = asList(
            (i) -> isFizz(i) ? "fizz" : null,
            (i) -> isBuzz(i) ? "buzz" : null
    );

    @Override
    public String apply(final Integer number) {
        return ofNullable(
                functions.stream()
                        .map((f) -> f.apply(number))
                        .reduce(null, FizzBuzzNumberConverter::append))
                .orElse(String.valueOf(number));
    }

    public static boolean isFizz(final Integer number) {
        return number != 0 && number % 3 == 0;
    }

    public static boolean isBuzz(final Integer number) {
        return number != 0 && number % 5 == 0;
    }

    public static String append(final String source, final String stringToAppend) {
        return ofNullable(source)
                .map((s1) -> s1 +
                        ofNullable(stringToAppend)
                                .map((s) -> " " + s)
                                .orElse(""))
                .orElse(stringToAppend);
    }

}
