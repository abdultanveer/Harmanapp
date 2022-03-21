package com.abdul.harmanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    lateinit var tvHome: TextView
    lateinit var etContact : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home)
        tvHome = findViewById(R.id.tvHome)
        etContact = findViewById(R.id.etContact)

        var dataReceived :String
        dataReceived = intent.extras?.getString("ip").toString()

       // tvHome.setText(dataReceived)
        tvHome.text = dataReceived
    }

    fun contactHandler(view: View) {//2
        when(view.id){
            R.id.button2 -> {sendContact()}
            R.id.btnAlarm -> { createAlarm("studytime",10,0)}
        }



    }

    private fun sendContact() {
        //get the string from etContact
        var contact = etContact.text.toString()
        //put it in the intent
        var resIntent = Intent()
        resIntent.putExtra("con", contact)
        //send that intent to the parentActivity[MainActivity]
        setResult(RESULT_OK, resIntent)
        //close this activity
        finish()
    }


    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}