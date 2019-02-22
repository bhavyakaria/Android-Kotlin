package parzival.com.androidkotlin

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(View.OnClickListener {
            type1()
        })

        button2.setOnClickListener(View.OnClickListener {
            type2()
        })
    }

    private fun type2() {

        val mBuilder : AlertDialog.Builder = AlertDialog.Builder(this)

        val layout = layoutInflater.inflate(R.layout.custom_layout,null)

        mBuilder.setView(layout)
        val dialog : AlertDialog = mBuilder.create()
        dialog.show()
    }

    private fun type1() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dialog One")

        builder.setMessage("Do you really want to leave?")

        builder.setPositiveButton("Yes"){ dialog, which ->
            Toast.makeText(applicationContext,"Okay bye bye.",Toast.LENGTH_LONG).show()
        }

        builder.setNegativeButton("No"){ dialog, which ->
            Toast.makeText(applicationContext,"Good, you won't regret.",Toast.LENGTH_LONG).show()
        }

        builder.setNeutralButton("Cancle"){ dialog, which ->
            Toast.makeText(applicationContext,"Mistakes happen.",Toast.LENGTH_LONG).show()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
