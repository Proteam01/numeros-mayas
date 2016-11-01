package com.mayan.numbers.decimal.calculator;

import java.util.ArrayList;
import java.util.List;

public class DecimalToMayan {

    public List<Integer> getNumerics(int decimalNumber) {
        int num = decimalNumber;
        ArrayList<Integer> numbers = new ArrayList<>();
        int increment = 1;
        while (num != 0) {
            float divisor = increment * 20.0f;
            int newNumber = (int) (num / divisor);
            newNumber = (int) (newNumber * divisor);
            int reminder = (num - newNumber);
            numbers.add(reminder);
            num = newNumber / 20;
        }
        int size = numbers.size();
        ArrayList<Integer> newNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newNumbers.add( 0 ,  numbers.get(i) );
        }
        return newNumbers;
    }

}
