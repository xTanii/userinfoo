package com.example.tanyanarsinghani.userinfoo

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    val Tag = "Activity 2"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(Tag, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        val msgg = bundle!!.getString("user_name")
        val msgg1 = bundle.getString("user_contact")
        val msgg2 = bundle.getString("user_address")
        val m = bundle.getParcelable<Uri>("uri_extra")
        tvNAME.text = msgg
        tvCONTACT.text = msgg1
        tvADDRESS.text = msgg2
        userpicc.setImageURI(m)
        val actionbar= supportActionBar
        actionbar!!.title="Userinfo"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, "onDestroy")
    }
}

