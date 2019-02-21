package com.example.tanyanarsinghani.userinfoo.ActivityPackage


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.tanyanarsinghani.userinfoo.R
import com.example.tanyanarsinghani.userinfoo.Class.User
import com.example.tanyanarsinghani.userinfoo.Class.UserRepository
import kotlinx.android.synthetic.main.activity_second.*


class UserInfoDisplay: AppCompatActivity() {

    val Tag = UserInfoDisplay::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(Tag, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        val id  = bundle?.getInt("Id")
        if(id != null) {
            val user: User? =
                UserRepository.getUser(id)
            if(user != null) {
                tvnameofuser.text = user.name
              tvcontactofuser.text = user.contact.toString()
              tvaddressofuser.text = user.address

                userpic.setImageURI(user.uri)

            }
        }
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

