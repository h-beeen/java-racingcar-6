package racingcar.parser;

import racingcar.exception.RacingCarException;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

import static racingcar.exception.ErrorMessage.CONTAIN_IMPROPER_LETTER;

public class Parser {
    private static final String COMMA = ",";

    private Parser() {
    }

    public static List<String> parseCarNames(final String input) {
        InputValidator.validateEndsWithComma(input);
        return Arrays.stream(input.split(COMMA))
                .toList();
    }

    public static int parseRoundCount(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }
}
