package parzival.com.androidkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        })

        register.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        })

    }

    private fun intent() {

    }
}
