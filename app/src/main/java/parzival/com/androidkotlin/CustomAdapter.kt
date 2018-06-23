package parzival.com.androidkotlin

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.ArrayList

class CustomAdapter(val userList: ArrayList<DataClass>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.list, parent, false)

        return CustomAdapter.ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun remove(position: Int) {
        userList.removeAt(position)
        notifyItemRemoved(position)
    }

//    fun add(position: Int, string: String) {
//        userList.add(position, string)
//        notifyItemInserted(position)
//    }

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.viewModal, data)
            binding.executePendingBindings()
        }
    }

}