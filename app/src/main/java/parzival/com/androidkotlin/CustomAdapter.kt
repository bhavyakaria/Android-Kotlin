package parzival.com.androidkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list.view.*
import java.util.ArrayList

class CustomAdapter(val userList: ArrayList<DataClass>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list:DataClass = userList[position]
        holder.countryName.text = list.countryName
        holder.capital.text = list.capital
        holder.bind(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName = itemView.countryName
        val capital = itemView.capital

        fun bind(listViewItem: DataClass) {
            itemView.setOnClickListener(View.OnClickListener {

                Toast.makeText(
                        itemView.context,
                        "Country: " + listViewItem.countryName + "/n Capital: " + listViewItem.capital,
                        Toast.LENGTH_LONG).show()
            })
        }
    }

}