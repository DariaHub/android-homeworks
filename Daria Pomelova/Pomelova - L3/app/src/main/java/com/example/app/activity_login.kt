package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app.databinding.ActivityLoginBinding

class activity_login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BTSingIn.setOnClickListener {
            val password = binding.EDPassword.text.toString()
            val email = binding.EDEmail.text.toString()
            val Name = binding.EDEmail.text.toString()
            if(Validator.password_restriction(password) and Validator.email_restriction(email) == true){
                val intent = Intent(this, activity_profile::class.java)
                intent.putExtra("Name", Name)
                startActivity(intent)
            }
            else{
                if(Validator.password_restriction(password) == false) {
                    binding.TVError.visibility = View.VISIBLE
                    binding.TVError.text = "The password must consist of at least 8 characters. "
                }
                val text = binding.TVError.text.toString()
                if(Validator.email_restriction(email) == false) {
                    binding.TVError.visibility = View.VISIBLE
                    binding.TVError.text = text + "The mail must consist of at least 7 characters and contain the '@' character."
                }
            }
        }

        binding.TVSingIn.setOnClickListener {
            var intent = Intent(this, activity_register::class.java)
            startActivity(intent)
        }
    }
}