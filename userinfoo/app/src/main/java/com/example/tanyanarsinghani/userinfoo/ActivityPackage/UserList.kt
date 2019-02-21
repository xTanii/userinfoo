package com.example.tanyanarsinghani.userinfoo.ActivityPackage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.tanyanarsinghani.userinfoo.*
import com.example.tanyanarsinghani.userinfoo.Adaptor.CustomAdapter
import com.example.tanyanarsinghani.userinfoo.Class.User
import com.example.tanyanarsinghani.userinfoo.Class.UserRepository
import kotlinx.android.synthetic.main.recyclerview.*


class UserList : AppCompatActivity() {
    val Tag = UserList::class.java.simpleName
    val listOfUser: ArrayList<User> =
        UserRepository.getAll()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)
        Log.d(Tag, "onCreate")

        fab.setOnClickListener {
            val intent = Intent(this, UserInput::class.java)
            startActivity(intent)
        }
        userlistrecyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }


    override fun onStart() {
        super.onStart()

        if (listOfUser.isEmpty()) {
            userlistrecyclerview.setVisibility(View.GONE)
            empty_view.setVisibility(View.VISIBLE)
        } else {
            userlistrecyclerview.setVisibility(View.VISIBLE)
            empty_view.setVisibility(View.GONE)
            val adapter = CustomAdapter(listOfUser)
            {
                val intent = Intent(this, UserInfoDisplay::class.java)
                intent.putExtra("Id", it)
                startActivity(intent)
            }


            userlistrecyclerview.adapter = adapter

        }


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