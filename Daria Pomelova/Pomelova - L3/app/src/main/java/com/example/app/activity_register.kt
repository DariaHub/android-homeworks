package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app.databinding.ActivityRegisterBinding

class activity_register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    var Validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BTRegister.setOnClickListener {
            val password = binding.ETPassword.text.toString()
            val password2 = binding.ETConpassword.text.toString()
            val email = binding.ETEmail.text.toString()
            val name = binding.ETName.text.toString()
            if(Validator.email_restriction(email) and
                    Validator.password_restriction(password) and
                    Validator.confirm_password(password, password2) and
                    !(binding.ETName.text.toString().isEmpty()) == true){
                val intent = Intent(this, activity_login::class.java)
                startActivity(intent)
            }
            else{
                if(Validator.password_restriction(password) == false) {
                    binding.TVErrorr.visibility = View.VISIBLE
                    binding.TVErrorr.text = "The password must consist of at least 8 characters. "
                }
                var text = binding.TVErrorr.text.toString()
                if(Validator.email_restriction(email) == false) {
                    binding.TVErrorr.visibility = View.VISIBLE
                    binding.TVErrorr.text = text + "The mail must consist of at least 7 characters and contain the '@' character."
                }

            }
        }

        binding.tvSingIn.setOnClickListener {
            val intent = Intent(this, activity_login::class.java)
            startActivity(intent)
        }
    }
}