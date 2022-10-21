package com.example.jsonplaceholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.helpers.User

class UserAdapter(private val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewAdapter>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewAdapter {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.activity_user_detailed,
                parent,
                false
            )
        itemView.setOnClickListener{ view ->
            println("Click! ${view.tag}")
        }
        return UserViewAdapter(itemView)
    }

    override fun onBindViewHolder(holder: UserViewAdapter, position: Int) {
        val current = userList[position]
        holder.userEmail.text = current.email
        holder.userName.text = current.name
        holder.setViewTag(current.id)
    }

    override fun getItemCount(): Int = userList.size

    class UserViewAdapter(itemsView: View): RecyclerView.ViewHolder(itemsView){
        val userName: TextView = itemsView.findViewById(R.id.user_name)
        val userEmail: TextView = itemsView.findViewById(R.id.user_email)
        fun setViewTag(id: Byte) {
            val itemsView = itemView
            return itemsView.setTag(id)
        }
    }

}