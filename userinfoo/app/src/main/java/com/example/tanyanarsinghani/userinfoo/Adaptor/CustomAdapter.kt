package com.example.tanyanarsinghani.userinfoo.Adaptor


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tanyanarsinghani.userinfoo.R
import com.example.tanyanarsinghani.userinfoo.Class.User


class CustomAdapter(val userList: ArrayList<User>, val clickListener: (Int)->Unit ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position],position,clickListener)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User, position:  Int, clickListener: (Int) -> kotlin.Unit) {
            val textViewName = itemView.findViewById(R.id.recyclerviewusername) as TextView
            textViewName.text = user.name
            itemView.setOnClickListener {
                clickListener(user.userId)
            }


        }
    }
}