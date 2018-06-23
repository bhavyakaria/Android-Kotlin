package parzival.com.androidkotlin

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Any) {
        binding.setVariable(BR.viewModal, data)
        binding.executePendingBindings()
    }
}
