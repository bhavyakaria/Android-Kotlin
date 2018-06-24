package parzival.com.androidkotlin.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_blank.view.*

import parzival.com.androidkotlin.R
import parzival.com.androidkotlin.adapter.RecyclerViewAdapter
import parzival.com.androidkotlin.data_classes.ContactsModel


/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_blank, container, false)
        view.recyclerview.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false);

        val list = ArrayList<ContactsModel>()

        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))
        list.add(ContactsModel("Bhavya Karia","+91-9768736334"))

        val adapter = RecyclerViewAdapter(list)
        view.recyclerview.adapter = adapter

        return view
    }


}
