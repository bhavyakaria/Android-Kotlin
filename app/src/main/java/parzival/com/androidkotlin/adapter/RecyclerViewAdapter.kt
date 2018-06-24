package parzival.com.androidkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list.view.*
import parzival.com.androidkotlin.R
import parzival.com.androidkotlin.data_classes.ContactsModel

class RecyclerViewAdapter(val contactList: ArrayList<ContactsModel>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list:ContactsModel = contactList[position]
        holder.contactName.text = list.contactName
        holder.contactNumber.text = list.contactNumber
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val contactName = itemView.contactName
        val contactNumber = itemView.contactNumber
    }
}