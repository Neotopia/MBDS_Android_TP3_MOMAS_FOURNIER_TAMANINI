package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Afficher une page web
        // showWebPage()
        callMe()
    }

    fun showWebPage(){
        val chemin: Uri = Uri.parse("http://www.google.fr")
        val naviguer = Intent(Intent.ACTION_VIEW, chemin)
        startActivity(naviguer)
    }

    /**
     * fonction permettant d'appeller un num de téléphone
     */
    fun callMe(){
        val numero = Uri.parse("tel:0123456789");
        val appeler = Intent(Intent.ACTION_CALL, numero);
        startActivity(appeler);
    }

}
