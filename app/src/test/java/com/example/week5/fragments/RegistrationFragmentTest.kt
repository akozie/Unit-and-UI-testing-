package com.example.week5.fragments

import org.junit.Assert.*
import org.junit.Test

class RegistrationFragmentTest{

    var validName = RegistrationFragment()

   @Test
  fun validNameTest(){
      assertEquals(true, validName.validName())
   }

    @Test
    fun validNumberTest(){
        assertEquals(true, validName.validNumber("09087654321"))
    }
    @Test
    fun validEmailTest(){
        assertEquals(true, validName.validEmail("akoziemmanuel@gmail.com"))
    }


}