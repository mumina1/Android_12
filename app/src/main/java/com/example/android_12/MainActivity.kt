package com.example.android_12

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    private lateinit var btnWhatsapp:MaterialCardView
    private lateinit var etInput:EditText
    private lateinit var btnTransition: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWhatsapp = this.findViewById(R.id.tv_whatsapp)
        etInput = this.findViewById(R.id.et_inpat)
        btnTransition = this.findViewById(R.id.btn_transition)

        goToWhatsapp()

        transitionToSecondActivity()
    }

    private fun goToWhatsapp() {
        btnWhatsapp.setOnClickListener{
            val whatsappSearchUrl = "\"http://api.whatsapp.com/send?phone"
            val query = etInput.text.toString().trim()
            // Неявное намерение
            val whatsappIntent = Intent(Intent.ACTION_VIEW, Uri.parse("$whatsappSearchUrl$query"))
            startActivity(whatsappIntent)

        }
    }
    private fun transitionToSecondActivity() {
        btnTransition.setOnLongClickListener{
            //Явный намерение
            val transitionIntent = Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
            false
        }
    }
}