package com.lazday.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lazday.sharedpreferences.helper.Constant
import com.lazday.sharedpreferences.helper.PrefHelper
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        prefHelper = PrefHelper(this)

        textUsername.text = prefHelper.getString( Constant.PREF_USERNAME )

        buttonLogout.setOnClickListener {
            prefHelper.clear()
            showMessage( "Keluar" )
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}