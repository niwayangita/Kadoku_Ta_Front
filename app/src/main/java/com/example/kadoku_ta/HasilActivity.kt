package com.example.kadoku_ta

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject

class HasilActivity : AppCompatActivity() {
    private var JSON_STRING: String? = null
    val Konfigurasi = Konfigurasi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)


        val jk = intent.getStringExtra("jk").toString()
        val hobi = intent.getStringExtra("hobi").toString()
        val crispExtra = intent.getIntExtra("crispExtra",0)
        val crispAgree = intent.getIntExtra("crispAgree",0)
        val crispCons = intent.getIntExtra("crispCons",0)
        val crispNeuro = intent.getIntExtra("crispNeuro",0)
        val crispOpen = intent.getIntExtra("crispOpen",0)
        val kategori = intent.getStringExtra("kategori")

        val extra = findViewById<TextView>(R.id.textViewExtra)
        extra.text = "Extraversion: " + crispExtra.toString()

        var dk_rendahE=0.0
        var dk_sedangE=0.0
        var dk_tinggiE=0.0

        //fuzzifikasi extra
        if (crispExtra<=8){
            dk_rendahE = 1.0
            dk_sedangE = 0.0
            dk_tinggiE = 0.0
        }
        else if(crispExtra> 8 && crispExtra<20)
        {
            dk_rendahE = (20.0-crispExtra)/(20-8)
            dk_sedangE = (crispExtra-8.0)/(20-8)
            dk_tinggiE = 0.0
        }
        else if(crispExtra == 20){
            dk_rendahE = 0.0
            dk_sedangE = 1.0
            dk_tinggiE = 0.0
        }
        else if(crispExtra > 20.0 && crispExtra <32.0){
            dk_rendahE = 0.0
            dk_sedangE = (32.0-crispExtra)/(32-20)
            dk_tinggiE = (crispExtra-20.0)/(32-20)
        }
        else if(crispExtra >= 32){
            dk_rendahE = 0.0
            dk_sedangE = 0.0
            dk_tinggiE = 1.0
        }

        val agree = findViewById<TextView>(R.id.textViewAgree)
        agree.text = "Agreeableness: " + crispAgree.toString()

        var dk_rendahA = 0.0
        var dk_sedangA = 0.0
        var dk_tinggiA = 0.0

        //fuzzifikasi Agreeableness
        if (crispAgree<=8){
            dk_rendahA = 1.0
            dk_sedangA = 0.0
            dk_tinggiA = 0.0
        }
        else if(crispAgree> 8 && crispAgree<20)
        {
            dk_rendahA = (20.0-crispAgree)/(20-8)
            dk_sedangA = (crispAgree-8.0)/(20-8)
            dk_tinggiA = 0.0
        }
        else if(crispAgree == 20){
            dk_rendahA = 0.0
            dk_sedangA = 1.0
            dk_tinggiA = 0.0
        }
        else if(crispAgree > 20 && crispAgree <32){
            dk_rendahA = 0.0
            dk_sedangA = (32.0-crispAgree)/(32-20)
            dk_tinggiA = (crispAgree-20.0)/(32-20)
        }
        else if(crispAgree >= 32){
            dk_rendahA = 0.0
            dk_sedangA = 0.0
            dk_tinggiA = 1.0
        }

        val cons = findViewById<TextView>(R.id.textViewCons)
        cons.text = "Conscientiousness: " + crispCons.toString()

        var dk_rendahC = 0.0
        var dk_sedangC = 0.0
        var dk_tinggiC = 0.0

        //fuzzifikasi Conscientiousness
        if (crispCons<=8){
            dk_rendahC = 1.0
            dk_sedangC = 0.0
            dk_tinggiC = 0.0
        }
        else if(crispCons> 8 && crispCons<20)
        {
            dk_rendahC = (20.0-crispExtra)/(20-8)
            dk_sedangC = (crispExtra-8.0)/(20-8)
            dk_tinggiC = 0.0
        }
        else if(crispCons == 20){
            dk_rendahC = 0.0
            dk_sedangC = 1.0
            dk_tinggiC = 0.0
        }
        else if(crispCons > 20 && crispCons <32){
            dk_rendahC = 0.0
            dk_sedangC = (32.0-crispCons)/(32-20)
            dk_tinggiC = (crispCons-20.0)/(32-20)
        }
        else if(crispCons >= 32){
            dk_rendahC = 0.0
            dk_sedangC = 0.0
            dk_tinggiC = 1.0
        }


        val neuro = findViewById<TextView>(R.id.textViewNeuro)
        neuro.text = "Neuroticism: " + crispNeuro.toString()

        var dk_rendahN = 0.0
        var dk_sedangN = 0.0
        var dk_tinggiN = 0.0

        //fuzzifikasi Neuroticism
        if (crispNeuro<=8){
            dk_rendahN = 1.0
            dk_sedangN = 0.0
            dk_tinggiN = 0.0
        }
        else if(crispNeuro> 8 && crispNeuro<20)
        {
            dk_rendahN = (20.0-crispNeuro)/(20-8)
            dk_sedangN = (crispNeuro-8.0)/(20-8)
            dk_tinggiN = 0.0
        }
        else if(crispNeuro == 20){
            dk_rendahN = 0.0
            dk_sedangN = 1.0
            dk_tinggiN = 0.0
        }
        else if(crispNeuro > 20 && crispNeuro <32){
            dk_rendahN = 0.0
            dk_sedangN = (32.0-crispNeuro)/(32-20)
            dk_tinggiN = (crispNeuro-20.0)/(32-20)
        }
        else if(crispNeuro >= 32){
            dk_rendahN = 0.0
            dk_sedangN = 0.0
            dk_tinggiN = 1.0
        }


        val open = findViewById<TextView>(R.id.textViewOpen)
        open.text = "Openness: " + crispOpen.toString()

        var dk_rendahO = 0.0
        var dk_sedangO = 0.0
        var dk_tinggiO = 0.0

        //fuzzifikasi Openness
        if (crispOpen<=8){
            dk_rendahO = 1.0
            dk_sedangO = 0.0
            dk_tinggiO = 0.0
        }
        else if(crispOpen> 8 && crispOpen<20)
        {
            dk_rendahO = (20.0-crispOpen)/(20-8)
            dk_sedangO = (crispOpen-8.0)/(20-8)
            dk_tinggiO = 0.0
        }
        else if(crispOpen == 20){
            dk_rendahO = 0.0
            dk_sedangO = 1.0
            dk_tinggiO = 0.0
        }
        else if(crispOpen > 20 && crispOpen <32){
            dk_rendahO = 0.0
            dk_sedangO = (32.0-crispOpen)/(32-20)
            dk_tinggiO = (crispOpen-20.0)/(32-20)
        }
        else if(crispOpen >= 32){
            dk_rendahO = 0.0
            dk_sedangO = 0.0
            dk_tinggiO = 1.0
        }

        val tampilOpenRendah = findViewById<TextView>(R.id.textViewRendah)
        val tampilOpenSedang = findViewById<TextView>(R.id.textViewSedang)
        val tampilOpenTinggi = findViewById<TextView>(R.id.textViewTinggi)
        val cek = findViewById<TextView>(R.id.textView15)

        tampilOpenRendah.text = dk_rendahO.toString()
        tampilOpenSedang.text = dk_sedangO.toString()
        tampilOpenTinggi.text = dk_tinggiO.toString()
        cek.text = kategori.toString()
    }
}