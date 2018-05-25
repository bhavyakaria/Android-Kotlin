package parzival.com.androidkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        btn_register.setOnClickListener(View.OnClickListener {
            view -> register()
        })
    }
    private fun register() {
        val name = reg_name.text.toString()
        log(name)
        val email = login_email.text.toString()
        log(email)
        val password = login_password.text.toString()
        log(password)

        if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful) {
                    val userName = mAuth.currentUser
                    val uid = userName!!.uid
                    mDatabase.child(uid).child("Name").setValue(name)
                    toast("Sign Up successful!")
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    toast("Error in Sign Up! ${task.exception?.message}")
                    log("Error: ${task.exception?.message}")
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
        Toast.makeText(applicationContext,data,Toast.LENGTH_LONG).show()
    }
}
