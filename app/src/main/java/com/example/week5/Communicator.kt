package com.example.week5

import android.widget.Spinner

interface Communicator {
    fun passData(
        editTextInput: String,
        editNumberInput: String,
        editEmailInput: String,
        editGenderInput: String
    )
}