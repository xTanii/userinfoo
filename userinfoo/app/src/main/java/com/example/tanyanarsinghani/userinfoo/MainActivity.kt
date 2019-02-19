package com.example.tanyanarsinghani.userinfoo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import android.provider.MediaStore
import android.net.Uri
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    val Tag = "Activity 1"
    val PICK_IMAGE_REQUEST = 1
    var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        togetpic.setOnClickListener {
            val intent = Intent()

            intent.type = "image/*";
            intent.action = Intent.ACTION_GET_CONTENT;
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        }

        tonextactivity.setOnClickListener {
            Log.d(Tag, "onCreate")
            val intent = Intent(this, SecondActivity::class.java)
            val msg: String = etname.text.toString().trim()
            val msg1: String = etcontact.text.toString()
            val msg2: String = etaddress.text.toString()
            if (msg.isNotEmpty() && msg1.isNotEmpty() && msg2.isNotEmpty()) {
                intent.putExtra("user_name", msg)
                intent.putExtra("user_contact", msg1)
                intent.putExtra("user_address", msg2)
                intent.putExtra("uri_extra", uri)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Error msg", Toast.LENGTH_LONG).show()


            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode === PICK_IMAGE_REQUEST && resultCode === android.app.Activity.RESULT_OK && intent?.data != null) {

            uri = intent?.data


            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                // Log.d(TAG, String.valueOf(bitmap));

                val imageView = findViewById<View>(R.id.userpicc) as ImageView
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