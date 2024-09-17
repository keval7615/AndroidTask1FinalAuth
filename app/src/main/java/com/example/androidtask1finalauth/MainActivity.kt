package com.example.androidtask1finalauth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtask1finalauth.databinding.ActivityMainBinding
import com.example.androidtask1finalauth.utils.Validationutil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var count = 0
    var evalid = false
    var pvalid = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            var intent = Intent(this, Registration::class.java)
            startActivity(intent)

        }

//by defaultly button desable
        binding.btnLogin.isEnabled = false
        binding.btnLogin.setBackgroundResource(R.drawable.bg_default_et_bg)



        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                valideinE()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.etPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validatinP()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })




        if (count == 3) {

//            var intent = Intent(this, DashBoardActivity::class.java)
//            startActivity(intent)
        }
    }


    private fun validatinP() {
        var password = binding.etPass.text.toString().trim()
        if (password.isBlank()) {
            binding.tilPassLogin.error = "this field is empty"
            binding.tilPassLogin.requestFocus()

        } else {
            if (!Validationutil.isValidPassword(password)) {
                binding.tilPassLogin.error = "Password Not mached"

            } else {
                binding.tilPassLogin.error = null
                evalid=true
                makeEnableBtn()
            }
        }

    }

    private fun valideinE() {
        var email = binding.etEmail.text.toString().trim()

            if (email.isBlank()) {
                binding.tilEmaillLogin.error = "this field is empty"
                binding.tilEmaillLogin.requestFocus()

            } else {
                if (!Validationutil.isValidEmail(email)) {
                    binding.tilEmaillLogin.error = "Not email matched"
                    binding.tilEmaillLogin.requestFocus()
                } else {
                    binding.tilEmaillLogin.error = null
                    pvalid=true
                    makeEnableBtn()
                }

            }
        }
    private fun makeEnableBtn(){

        if (pvalid && evalid){
            binding.btnLogin.isEnabled = true
            binding.btnLogin.setBackgroundResource(R.drawable.bg)
        }
        else{
            binding.btnLogin.isEnabled = false
            binding.btnLogin.setBackgroundResource(R.drawable.bg_default_et_bg)
        }
    }


    }

