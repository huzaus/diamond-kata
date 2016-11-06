package com.huzaus;

import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

public class Diamond {

    private static final char A = 'A';
    private static final char Z = 'Z';
    private static final String SEPARATOR = " ";
    private static final String LINE_SEPARATOR = "\n";

    public static String apply(char symbol) {
        validate(symbol);
        return A == symbol ? String.valueOf(symbol) : range(symbol, A)
                .mapToObj((i) -> withIndent(lineOf(i), symbol - i))
                .reduce(lineOf(symbol), (acc, line) -> join(LINE_SEPARATOR + acc + LINE_SEPARATOR, nCopies(2, line)));
    }

    private static void validate(char symbol) {
        if (A > symbol || symbol > Z) {
            throw new IllegalArgumentException();
        }
    }

    private static String lineOf(int symbol) {
        return lineOf((char) symbol);
    }

    private static String lineOf(char symbol) {
        String symbolAsString = String.valueOf(symbol);
        return A == symbol ? symbolAsString : join(
                join("", nCopies(2 * (symbol - A) - 1, SEPARATOR)),
                nCopies(2, symbolAsString)
        );
    }

    private static String withIndent(String line, int indent) {
        return withIndent(line, (char) indent);
    }

    private static String withIndent(String line, char indent) {
        return indent == 0 ? line : join(
                line,
                nCopies(2, join("", nCopies(indent, SEPARATOR))));
    }

    private static IntStream range(int from, int to) {
        return IntStream.range(to, from).map(i -> from - i + to - 1);
    }
}
