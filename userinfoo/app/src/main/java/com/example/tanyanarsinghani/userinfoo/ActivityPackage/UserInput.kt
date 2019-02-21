package com.example.tanyanarsinghani.userinfoo.ActivityPackage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.tanyanarsinghani.userinfoo.R
import com.example.tanyanarsinghani.userinfoo.Class.User
import com.example.tanyanarsinghani.userinfoo.Class.UserRepository
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.*



class UserInput : AppCompatActivity() {
    val Tag = UserInput::class.java.simpleName
    val PICK_IMAGE_REQUEST = 1
    var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        togetpic.setOnClickListener {
            val intent = Intent()

            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
        }

        touserinfodisplay.setOnClickListener {
            Log.d(Tag, "onCreate")

            val intent = Intent(this, UserInfoDisplay::class.java)
            val username: String = etnameofuser.text.toString().trim()
            val usercontactnumber: Int = etcontactofuser.text.toString().toInt()
            val useraddress: String = etaddressofuser.text.toString()

            if (username.isNotEmpty() && usercontactnumber.toString().isNotEmpty() && useraddress.isNotEmpty()) {
                var userId = (0..100000000000).random().toInt()




                UserRepository.addUser(
                    User(
                        userId,
                        username,
                        usercontactnumber,
                        useraddress,
                        uri
                    )
                )
                intent.putExtra("Id", userId)

                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Error msg", Toast.LENGTH_LONG).show()


            }
        }

        val actionbar = supportActionBar
        actionbar!!.title = "Userinfo"
        actionbar.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode === PICK_IMAGE_REQUEST && resultCode === android.app.Activity.RESULT_OK && intent?.data != null) {

            uri = intent.data


            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                // Log.d(TAG, String.valueOf(bitmap));

                val imageView = findViewById<View>(R.id.userpic) as ImageView
                imageView.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }


        }


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