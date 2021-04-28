package com.example.week5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.week5.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var displayMessageName: String? = ""
    private var displayMessagePhone: String? = ""
    private var displayMessageEmail: String? = ""
    private var displayMessageGender: String? = ""





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        val displayName = view.findViewById<TextView>(R.id.displayName)
        val displayPhone = view.findViewById<TextView>(R.id.displayPhoneNumber)
        val displayEmail = view.findViewById<TextView>(R.id.displayEmail)
        val displayGender = view.findViewById<TextView>(R.id.displayGender)

        displayMessageName = arguments?.getString("message")
        displayMessagePhone = arguments?.getString("messagePhone")
        displayMessageEmail = arguments?.getString("messageEmail")
        displayMessageGender = arguments?.getString("messageGender")

        displayName.text = displayMessageName
        displayPhone.text = displayMessagePhone
        displayEmail.text = displayMessageEmail
        displayGender.text = displayMessageGender


        return view
    }


}