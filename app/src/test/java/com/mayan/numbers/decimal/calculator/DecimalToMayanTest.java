package com.mayan.numbers.decimal.calculator;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DecimalToMayanTest{

    private DecimalToMayan decimalToMayan = new DecimalToMayan();

    @Test
    public void testGetNumerics(){
        List<Integer> nums = decimalToMayan.getNumerics(400);
        List<Integer> expectedNumbers = new ArrayList<Integer>(){{
            add(1);
            add(0);
            add(0);
        }};
        assertThat( nums , is( equalTo(expectedNumbers) ) );
    }

}