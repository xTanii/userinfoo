package com.example.tanyanarsinghani.userinfoo.Class

import android.util.Log
import java.util.ArrayList

object UserRepository {

    var listOfUser: ArrayList<User> = arrayListOf()


    fun addUser(user: User) {
        listOfUser.add(user)
        Log.d("Tag", "reached here $user")
    }

    fun getUser(userId: Int): User? {
        for (user in listOfUser) {
            if (user.userId==userId ) {
                return user
            }
        }
        return null
    }

    fun getAll(): ArrayList<User> {
        return listOfUser
    }
}


