package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.fixture.NameFixture.VALID_CAR_NAMES_INPUT;

@DisplayName("[InputValidator Test] - Domain Layer")
class InputValidatorTest {

    @Nested
    @DisplayName("[validateEndsWithComma] 쉼표(,)로 끝나는 입력값에 대해 예외를 던진다.")
    class validateEndsWithCommaTest {

        @Test
        @DisplayName("[Success] 정상적인 조건의 이름으로, 아무런 행동도 하지 않는다.")
        void Given_ValidNames_When_validateEndsWithComma_Then_DoNothing() {
            // given
            final String VALID_NAMES = VALID_CAR_NAMES_INPUT.getName();

            // when &&then
            assertDoesNotThrow(() -> InputValidator.validateEndsWithComma(VALID_NAMES));
        }

        @Test
        @DisplayName("[Exception] 구분자로 끝나는 이름 요청으로 예외를 던진다.")
        void Given_EndWithCommaRequest_When_validateEndsWithComma_Then_ThrowException() {
            // given
            final String DELIMITER = ",";
            final String ENDS_WITH_DELIMITER = VALID_CAR_NAMES_INPUT.getName() + DELIMITER;

            // when &&then
            assertThatThrownBy(() -> InputValidator.validateEndsWithComma(ENDS_WITH_DELIMITER))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessageContaining(ErrorMessage.ENDS_WITH_DELIMITER.getMessage());
        }
    }

    @Test
    @DisplayName("[Success] 정상적인 조건의 이름으로, 아무런 행동도 하지 않는다.")
    void Given_ValidNames_When_validateEndsWithComma_Then_DoNothing() {
        // given
        final String VALID_NAMES = VALID_CAR_NAMES_INPUT.getName();

        // when &&then
        assertDoesNotThrow(() -> InputValidator.validateEndsWithComma(VALID_NAMES));
    }

    @Test
    @DisplayName("[Exception] 구분자로 끝나는 이름 요청으로 예외를 던진다.")
    void Given_EndWithCommaRequest_When_validateEndsWithComma_Then_ThrowException() {
        // given
        final String DELIMITER = ",";
        final String ENDS_WITH_DELIMITER = VALID_CAR_NAMES_INPUT.getName() + DELIMITER;

        // when &&then
        assertThatThrownBy(() -> InputValidator.validateEndsWithComma(ENDS_WITH_DELIMITER))
                .isInstanceOf(RacingCarException.class)
                .hasMessageContaining(ErrorMessage.ENDS_WITH_DELIMITER.getMessage());
    }
}
}
