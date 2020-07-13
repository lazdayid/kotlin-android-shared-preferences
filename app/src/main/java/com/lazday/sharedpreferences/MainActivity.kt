package com.lazday.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lazday.sharedpreferences.helper.Constant
import com.lazday.sharedpreferences.helper.PrefHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefHelper = PrefHelper(this)

        buttonLogin.setOnClickListener {
            if (editUsername.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                saveSession( editUsername.text.toString(), editPassword.text.toString() )
                showMessage( "Berhasil login" )
                moveIntent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (prefHelper.getBoolean( Constant.PREF_IS_LOGIN )) {
            moveIntent()
        }
    }

    private fun saveSession(username: String, password: String){
        prefHelper.put( Constant.PREF_USERNAME, username )
        prefHelper.put( Constant.PREF_PASSWORD, password )
        prefHelper.put( Constant.PREF_IS_LOGIN, true)
    }

    private fun moveIntent(){
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}