package com.example.week5.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.week5.Communicator
import com.example.week5.R
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var spinner: Spinner? = null
    private var dropDownText: TextView? = null
    private var arrayAdapter: ArrayAdapter<String> ? = null
    private var itemList = arrayOf("Male", "Female")
    private lateinit var communicator: Communicator
    private lateinit var phoneNumber: EditText
    private lateinit var email: EditText
    private lateinit var sendBtn: Button
    private lateinit var name: EditText




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        var dropDownText = view.findViewById<EditText>(R.id.dropDownText)
        var spinner = view.findViewById<Spinner>(R.id.spinner)
        sendBtn = view.findViewById(R.id.sendBtn)
        name = view.findViewById(R.id.name)
        phoneNumber = view.findViewById(R.id.phoneNumber)
        email = view.findViewById(R.id.email)

        arrayAdapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, itemList) }
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this





        /**
         *  BUTTON FOR AN EMPTY FIELD
         * */
        communicator = activity as Communicator

        sendBtn.setOnClickListener {
            if(name.text.isEmpty() && phoneNumber.text.isEmpty() && email.text.isEmpty()){
                Toast.makeText(context, "Input your details", Toast.LENGTH_SHORT).show()
            } else if(validEmail(email.text.toString()) && validNumber(phoneNumber.text.toString())) {
                communicator.passData(name.text.toString(), phoneNumber.text.toString(), email.text.toString(), spinner.selectedItem.toString())
            }else{
                Toast.makeText(context, "Input your correct details", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(context , "Nothing Select", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item : String = parent?.getItemAtPosition(position) as String
//        dropDownText?.text  = item
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)


        phoneNumber.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (validNumber(phoneNumber.text.toString())){
                    sendBtn.isEnabled = true
                }else{
                    phoneNumber.error = "invalid"
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        email.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (validEmail(email.text.toString())){
                    sendBtn.isEnabled = true
                }else{
                    email.error = "wrong email"
                }
            }

        })

    }


     fun validEmail(text: String): Boolean {

        val email: Pattern = Pattern.compile( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
         val check = email.matcher(text)
         return check.matches()
    }

     fun validNumber(text: String): Boolean {
        val number: Pattern = Pattern.compile("^(\\+234|234|0)[789]\\d{9}")
        val check = number.matcher(text)
        return check.matches()
    }
}


