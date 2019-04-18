package io.androidedu.hoop.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import java.lang.Exception


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(io.androidedu.hoop.R.layout.activity_splash)
        val background = object:Thread(){
            override fun run() {
                try{
                    anim.playAnimation()
                    sleep(3000)
                val splaash = Intent(baseContext,MainActivity::class.java)
                        startActivity(splaash)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

}
