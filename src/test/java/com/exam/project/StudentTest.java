package com.exam.project;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class StudentTest {

    @InjectMocks
    private Student student;

    private static Stream<Arguments> positiveNumbers() {
        return Stream.of(
                            Arguments.of(1, "1"),
                            Arguments.of(2, "2"),
                            Arguments.of(3, "Fizz"),
                            Arguments.of(4, "4"),
                            Arguments.of(5, "Buzz"),
                            Arguments.of(6, "Fizz"),
                            Arguments.of(10, "Buzz"),
                            Arguments.of(15, "FizzBuzz"),
                            Arguments.of(98, "98"),
                            Arguments.of(99, "Fizz"),
                            Arguments.of(100, "Buzz")
                        );
    }

    @ParameterizedTest
    @MethodSource("positiveNumbers")
    void shouldAnswerWhenGivenValuesArePositiveNumbers(int number, String expected) {
        String result = student.answer(number);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> nonPositiveNumbers() {
        return Stream.of(
                        Arguments.of(0, "0"),
                        Arguments.of(-2, "-2"),
                        Arguments.of(-3, "-3"),
                        Arguments.of(100, "Buzz"),
                        Arguments.of(105, "105")
                     );
    }

    @ParameterizedTest
    @MethodSource("nonPositiveNumbers")
    void shouldAnswerWhenGivenValuesAreNonPositiveNumbers(int number, String expected) {
        String result = student.answer(number);
        assertThat(result).isEqualTo(expected);
    }
}