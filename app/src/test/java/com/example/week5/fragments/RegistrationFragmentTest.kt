package com.example.week5.fragments

import org.junit.Assert.*
import org.junit.Test

class RegistrationFragmentTest{

    var validator = RegistrationFragment()

//   @Test
//  fun validNameTest(){
//      assertEquals(true, validator.validName())
//   }

    @Test
    fun validNumberTest(){
        assertEquals(true, validator.validNumber("09087654321"))
    }
    @Test
    fun validEmailTest(){
        assertEquals(true, validator.validEmail("akoziemmanuel@gmail.com"))
    }


}