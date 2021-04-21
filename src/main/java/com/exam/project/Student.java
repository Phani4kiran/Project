package com.exam.project;

import org.springframework.stereotype.Service;

@Service
public class Student {
    public String answer(int number) {
        // for zero or negative numbers or greater than 100 numbers return the given value
        if (number == 0 || Math.max(number, 0) == 0 || Math.max(number,100) > 100) {
            return String.valueOf(number);
        } else if (number != 0 && number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
