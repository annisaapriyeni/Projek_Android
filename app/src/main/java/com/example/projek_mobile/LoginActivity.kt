package com.example.projek_mobile

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login)

        auth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener {
            if(inputuser.text.trim().toString().isNotEmpty() || inputpass.text.trim().toString().isNotEmpty()) {
                Login(inputpass.text.trim().toString(), inputpass.text.trim().toString());

            }else{
                Toast.makeText(this,"Input Required", Toast.LENGTH_LONG).show();
            }
        }


    }

    fun Login(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful){
                    val intent = Intent(this, MainActivity::class.java);
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Eror !!"+task.exception, Toast.LENGTH_LONG).show()
                }

            }

    }
}
