package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.week5.fragments.ProfileFragment
import com.example.week5.fragments.RegistrationFragment

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * INSTANCE OF THE REGISTRATIONFRAGMENT CLASS
         * */

        val registrationFragment = RegistrationFragment()
        currentFragment(registrationFragment)
    }

    /**
     * REPLACING THE FRAME LAYOUT WITH THE CURRENT FRAGMENT
     * */
    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame, fragment)
            commit()
        }



    /**
     * USING BUNDLE TO SAVE DATA
     * */
    override fun passData(
        editTextInput: String, editNumberInput: String, editEmailInput: String,
        editGenderInput: String
    ) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput )
        bundle.putString("messagePhone", editNumberInput)
        bundle.putString("messageEmail", editEmailInput )
        bundle.putString("messageGender", editGenderInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val profileFragment = ProfileFragment()
        profileFragment.arguments = bundle

        transaction.replace(R.id.frame, profileFragment)
            .addToBackStack(null).commit()
    }
}