 package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RekomendasiActivity : AppCompatActivity() {
    companion object{
        var JenisKelamin = ""
        var Hobi = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekomendasi)

        val btnRekom = findViewById<Button>(R.id.buttonRekom)
        val radioJK = findViewById<RadioGroup>(R.id.radioGroupJK)
        val spinnerHobi = findViewById<Spinner>(R.id.spinnerHobi)

        Hobi= spinnerHobi.selectedItem.toString()

        radioJK.setOnCheckedChangeListener{group, checkedId ->
            JenisKelamin= when(checkedId){
                    R.id.radioButtonLaki ->"laki"
                    R.id.radioButtonPerempuan -> "perempuan"
                else->""
            }
        }

        btnRekom.setOnClickListener{
            // Get the checked radio button id from radio group
//            var id: Int = radioJK.checkedRadioButtonId
//            if (id!=-1){ // If any radio button checked from radio group
//                // Get the instance of radio button using id
//                val radio: RadioButton = findViewById(id)
//                Toast.makeText(applicationContext,"On button click :" +
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
//            }else{
//                // If no radio button checked in this radio group
//                Toast.makeText(applicationContext,"On button click :" +
//                        " nothing selected",
//                    Toast.LENGTH_SHORT).show()
//            }

            //startActivity<ExtraversionActivity>(JenisKelamin to JenisKelamin)
            val intent = Intent(this, ExtraversionActivity::class.java)
            intent.putExtra("jk", JenisKelamin)
            intent.putExtra("hobi", Hobi)
            startActivity(intent)

//            Toast.makeText(applicationContext, Hobi,
//                    Toast.LENGTH_SHORT).show()
        }

//        btnRekom.setOnClickListener{
//            val intent = Intent(this, RekomendasiActivity::class.java)
//            startActivity(intent)
//        }

    }
}