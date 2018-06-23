package parzival.com.androidkotlin


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_sample.view.*

// 1. Declaring SampleFragment as a subclass of Fragment class
class SampleFragment : Fragment() {

    // 2. Providing a function to create a single instance of the fragment
    companion object {
        fun newInstance() : SampleFragment {
            return SampleFragment()
        }
    }

    // 3. Creates the view hierarchy controlled by the fragment.

    // LayoutInflater.inflate is used to inflate the fragment in the parent view(i.e container)
    // Three parameters are:
        // 1. Layout XML
        // 2. Parent view to which fragment will be attached -> container
        // 3. Whether the inflated fragment should be added to the container.
        //    (Always false because layout will be attached by FragmentManager)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_sample, container, false)

        view.recyclerView.layoutManager = LinearLayoutManager(context,LinearLayout.VERTICAL,false)
        val list = ArrayList<DataClass>()

        list.add(DataClass("India","New Delhi"))
        list.add(DataClass("Pakistan","Karachi"))
        list.add(DataClass("England","London"))

        val adapter = CustomAdapter(list)
        view.recyclerView.adapter = adapter

        return view
    }

    // onAttach() contains code that accesses the resources you need via the Context to which the fragment is attached.
    // Because the code is in onAttach(), you can rest assured that the fragment has a valid Context.
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }
}
