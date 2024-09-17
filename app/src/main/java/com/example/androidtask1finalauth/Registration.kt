package com.example.androidtask1finalauth

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidtask1finalauth.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    lateinit var binding:ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =  ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // gender list added
        val items = resources.getStringArray(R.array.Gender)
        val adapter = ArrayAdapter(this,R.layout.list_item,items)
        binding.ddGenderGet.setAdapter(adapter)

        //course list add
        val coursesList = listOf("Android Development","Web Development","Graphic Design")
        val adapter2 = ArrayAdapter(this,R.layout.list_item,coursesList)
        binding.ddCoursesGet.setAdapter(adapter2)




        binding.button2.setOnClickListener { onBackPressedDispatcher.onBackPressed() }


    }
}