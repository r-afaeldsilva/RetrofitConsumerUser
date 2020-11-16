package com.example.teste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teste.dominio.User


class ContactListAdapter (private val userList:List<User>):RecyclerView.Adapter<ContactListAdapter.ContactListVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_contact_list, parent, false)
        return ContactListVH(view)
    }

    override fun onBindViewHolder(holder: ContactListVH, position: Int) {
        val user=userList[position]
        holder.apply {
            userName.text = user.name
            userEmail.text = user.email
            userAddress.text = "${user.address?.street}, ${user.address?.suite} - ${user.address?.city}"
            userPhone.text = user.phone
            userWebsite.text = user.website

        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ContactListVH(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val userName:AppCompatTextView=itemView.findViewById(R.id.tv_name_value)
        val userEmail:AppCompatTextView=itemView.findViewById(R.id.tv_email_value)
        val userAddress:AppCompatTextView=itemView.findViewById(R.id.tv_address_value)
        val userPhone:AppCompatTextView=itemView.findViewById(R.id.tv_phone_value)
        val userWebsite:AppCompatTextView=itemView.findViewById(R.id.tv_website_value)
    }
}