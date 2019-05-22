package com.tinkerbyte.intentexample_kotlin

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun processFun(view: View){
        var mIntent: Intent? = null
        var choose:Intent? = null
        when(view.id)
        {
            R.id.Email ->{
                mIntent = Intent(Intent.ACTION_SEND)
                mIntent.setData(Uri.parse("mailto:"))
                mIntent.putExtra(Intent.EXTRA_EMAIL, "ashuverma.stp@gmail.com")// Receiver Email
                mIntent.putExtra(Intent.EXTRA_SUBJECT,"My First Email") //Subject of Email
                mIntent.putExtra(Intent.EXTRA_TEXT, "This is an example of Intent") //Body of Email
                mIntent.setType("message/rfc822")
                choose = Intent.createChooser(mIntent,"Select an App ")
                startActivity(choose)

            }
            R.id.InstallApp ->{
                mIntent = Intent(Intent.ACTION_VIEW)
                mIntent.setData(Uri.parse("market://details?id=com.jio.jioplay.tv&hl=en_IN"))
                choose = Intent.createChooser(mIntent,"Select an App")
                startActivity(choose)

            }
        }

    }
}
