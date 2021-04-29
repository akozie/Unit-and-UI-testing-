package com.example.week5.fragments

import org.junit.Assert.*
import org.junit.Test

class RegistrationFragmentTest{

    var validator = RegistrationFragment()

    /**
     * TESTING VALID INPUTS
     * */
    @Test
    fun validNumberTest(){
        assertEquals(true, validator.validNumber("09087654321"))
    }

    @Test
    fun validNumberSecondTest(){
        assertEquals(true, validator.validNumber("2349087654321"))
    }

    @Test
    fun validNumberThirdTest(){
        assertEquals(true, validator.validNumber("+2349087654321"))
    }


    @Test
    fun validEmailTest(){
        assertEquals(true, validator.validEmail("akoziemmanuel@gmail.com"))
    }

    /**
     * TESTING INVALID INPUTS
     * */
    @Test
    fun inValidNumberTest(){
        assertEquals(false, validator.validNumber("99087654321"))
    }

    @Test
    fun inValidEmailTest(){
        assertEquals(false, validator.validEmail("@gmail.com"))
    }


}