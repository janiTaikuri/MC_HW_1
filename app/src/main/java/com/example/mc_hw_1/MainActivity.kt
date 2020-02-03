package com.example.mc_hw_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fabOpened = false

        fab_time.setOnClickListener {
            startActivity(Intent(applicationContext, TimeActivity::class.java))

        }

        fab_map.setOnClickListener {
            val intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)

        }

        fab.setOnClickListener {
            if(!fabOpened){

                fabOpened = true
                fab_map.animate().translationY(-resources.getDimension(R.dimen.standard_66))
                fab_time.animate().translationY(-resources.getDimension(R.dimen.standard_116))

            }else{

                fabOpened = false
                fab_map.animate().translationY(0f)
                fab_time.animate().translationY(0f)
            }
        }

        val data = arrayOf("Oulu", "Espoo", "Helsinki")
        val reminderAdapter = ReminderAdapter(applicationContext, data)
        list.adapter = reminderAdapter

    }
}
