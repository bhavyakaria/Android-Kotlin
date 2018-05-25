package parzival.com.androidkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener(View.OnClickListener {
            view -> login()
        })
    }

    private fun login() {
        val email = login_email.text.toString()
        log(email)
        val password = login_password.text.toString()
        log(password)

        if(!email.isEmpty() && !password.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful) {
                    startActivity(Intent(this, WelcomeActivity :: class.java))
                    toast("Successfully logged in!")
                } else {
                    toast("Error in Log In!")
                }

            })
        } else {
            toast("Please enter credentials")
        }
    }

    private fun log(data: String) {
        Log.d("Parzival",data)
    }

    private fun toast(data: String) {
        Toast.makeText(applicationContext,data, Toast.LENGTH_LONG).show()
    }
}
