package com.example.motivatemeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
//    Override lifecycle method onCreate. This should initialize all important items for the code.

    private lateinit var name : EditText
    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//    Inflate the given layout to turn xml views into kotlin objects
        setContentView(R.layout.activity_main)

//    Get a reference to the button view from our layout and set a clickListener
    val updateButton: Button = findViewById(R.id.main_activity_bt_update)
    updateButton.setOnClickListener {
//        Log.i("test", "Button is pressed!")
        updateMessage()

    }
        name = findViewById(R.id.main_activity_et_name)
        message = findViewById(R.id.main_activity_tv_message)



    }


    //    Get a name from an editText and display a personalized message
    private fun updateMessage(){

//        Get the username from the editText
        val username = name.text

//        Pick a motivational message
        val motivationalMessages = listOf("Keep working hard!", "Never give up!", "Keep your head up!", "Difficulty is growth!","Today is the first day of the rest of you life!")
        val index = (0..4).random()
        val currentMessage = motivationalMessages[index]

        if(username.toString() == ""){
            message.text = "Make sure to enter your name!"
        }else {
            //        update the textView to display our message
            message.text = "Hello $username! $currentMessage"
        }

//      Clear the editText and use setText because editText's require an editable
        name.setText("")
        hideKeyboard()
    }

    private fun hideKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }


}