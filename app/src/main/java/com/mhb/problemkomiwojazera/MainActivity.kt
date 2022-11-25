package com.mhb.problemkomiwojazera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Vertex(val NumOVer : Int) {
    val Connections: IntArray = IntArray(NumOVer)
    var ConnectedTo: IntArray = IntArray(0)
    var Data = ""

    fun Connect(to : Int, weight : Int){
        if(to >= 1 && to<=Connections.size){
            if(weight >= 0){
                Connections[to]=weight
            }
        }
        UpdateConnectedTo()
    }

    fun UpdateConnectedTo(){
        ConnectedTo = IntArray(0)
        for(i in 0..Connections.size-1){
            if(Connections[i]>=1){
                ConnectedTo+=i
            }
        }
    }

    fun SetData(value : String){
        Data=value;
    }
}// End of class Vertex

class Matrix(val NumberOfVertices : Int){
    var Verticies : Array<Vertex> = arrayOf(Vertex(NumberOfVertices))
    val NOV = NumberOfVertices

    fun CreateVerticies(){
        for( i in 0..NOV-2){
            Verticies = Verticies+ arrayOf(Vertex(NOV))
        }
    }
}// End of class Matrix


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_miasto_next : Button = findViewById(R.id.button_miasto_next)
        val button_miasto_prev : Button = findViewById(R.id.button_miasto_prev)
        val input_miasto_name : EditText = findViewById(R.id.obecne_miasto_nazwa)

        val list01_miasto : TextView = findViewById(R.id.miasto01_nazwa)
        val list02_miasto : TextView = findViewById(R.id.miasto02_nazwa)
        val list03_miasto : TextView = findViewById(R.id.miasto03_nazwa)
        val list04_miasto : TextView = findViewById(R.id.miasto04_nazwa)
        val list05_miasto : TextView = findViewById(R.id.miasto05_nazwa)
        val list06_miasto : TextView = findViewById(R.id.miasto06_nazwa)
        val list07_miasto : TextView = findViewById(R.id.miasto07_nazwa)
        val list08_miasto : TextView = findViewById(R.id.miasto08_nazwa)
        val list09_miasto : TextView = findViewById(R.id.miasto09_nazwa)
        val list10_miasto : TextView = findViewById(R.id.miasto10_nazwa)
        val list11_miasto : TextView = findViewById(R.id.miasto11_nazwa)
        val list12_miasto : TextView = findViewById(R.id.miasto12_nazwa)
        val list13_miasto : TextView = findViewById(R.id.miasto13_nazwa)
        val list14_miasto : TextView = findViewById(R.id.miasto14_nazwa)
        val list15_miasto : TextView = findViewById(R.id.miasto15_nazwa)
        val list16_miasto : TextView = findViewById(R.id.miasto16_nazwa)

        val list01_weight : EditText = findViewById(R.id.miasto01_odleglosc)
        val list02_weight : EditText = findViewById(R.id.miasto02_odleglosc)
        val list03_weight : EditText = findViewById(R.id.miasto03_odleglosc)
        val list04_weight : EditText = findViewById(R.id.miasto04_odleglosc)
        val list05_weight : EditText = findViewById(R.id.miasto05_odleglosc)
        val list06_weight : EditText = findViewById(R.id.miasto06_odleglosc)
        val list07_weight : EditText = findViewById(R.id.miasto07_odleglosc)
        val list08_weight : EditText = findViewById(R.id.miasto08_odleglosc)
        val list09_weight : EditText = findViewById(R.id.miasto09_odleglosc)
        val list10_weight : EditText = findViewById(R.id.miasto10_odleglosc)
        val list11_weight : EditText = findViewById(R.id.miasto11_odleglosc)
        val list12_weight : EditText = findViewById(R.id.miasto12_odleglosc)
        val list13_weight : EditText = findViewById(R.id.miasto13_odleglosc)
        val list14_weight : EditText = findViewById(R.id.miasto14_odleglosc)
        val list15_weight : EditText = findViewById(R.id.miasto15_odleglosc)
        val list16_weight : EditText = findViewById(R.id.miasto16_odleglosc)

        val text_process : TextView = findViewById(R.id.textview_process)
        val button_save : Button = findViewById(R.id.button_zapisz)
        val text_wynik: TextView = findViewById(R.id.textview_wynik)

        val Macierz = Matrix(16)
        Macierz.CreateVerticies()
        Toast.makeText(applicationContext, Macierz.Verticies.size.toString(), Toast.LENGTH_SHORT).show()

        var WybraneMiasto = 0

        fun ZmianaWybranegoMisata(change:Int){

            Macierz.Verticies[WybraneMiasto].Data=input_miasto_name.text.toString()
            var miastoname= Macierz.Verticies[WybraneMiasto].Data

            input_miasto_name.setText(miastoname)

            when(WybraneMiasto){
                0 -> list01_miasto.text=miastoname
                1 -> list02_miasto.text=miastoname
                2 -> list03_miasto.text=miastoname
                3 -> list04_miasto.text=miastoname
                4 -> list05_miasto.text=miastoname
                5 -> list06_miasto.text=miastoname
                6 -> list07_miasto.text=miastoname
                7 -> list08_miasto.text=miastoname
                8 -> list09_miasto.text=miastoname
                9 -> list10_miasto.text=miastoname
                10 -> list11_miasto.text=miastoname
                11 -> list12_miasto.text=miastoname
                12 -> list13_miasto.text=miastoname
                13 -> list14_miasto.text=miastoname
                14 -> list15_miasto.text=miastoname
                15 -> list16_miasto.text=miastoname
            }

            WybraneMiasto+=change

            if(WybraneMiasto<= 0){
                WybraneMiasto=0
            }
            if(WybraneMiasto>=15){
                WybraneMiasto=15
            }

            miastoname= Macierz.Verticies[WybraneMiasto].Data

            input_miasto_name.setText(miastoname)

            when(WybraneMiasto){
                0 -> list01_miasto.text=miastoname
                1 -> list02_miasto.text=miastoname
                2 -> list03_miasto.text=miastoname
                3 -> list04_miasto.text=miastoname
                4 -> list05_miasto.text=miastoname
                5 -> list06_miasto.text=miastoname
                6 -> list07_miasto.text=miastoname
                7 -> list08_miasto.text=miastoname
                8 -> list09_miasto.text=miastoname
                9 -> list10_miasto.text=miastoname
                10 -> list11_miasto.text=miastoname
                11 -> list12_miasto.text=miastoname
                12 -> list13_miasto.text=miastoname
                13 -> list14_miasto.text=miastoname
                14 -> list15_miasto.text=miastoname
                15 -> list16_miasto.text=miastoname
            }

        }//Koniec Funkcji zmiany wybranego miasta

        for(x in 0..15) {

            var miastoname = "Miasto "+(x+1).toString()

            Macierz.Verticies[x].Data=miastoname.toString()

            when(x){
            0 -> list01_miasto.text = miastoname
            1 -> list02_miasto.text = miastoname
            2 -> list03_miasto.text = miastoname
            3 -> list04_miasto.text = miastoname
            4 -> list05_miasto.text = miastoname
            5 -> list06_miasto.text = miastoname
            6 -> list07_miasto.text = miastoname
            7 -> list08_miasto.text = miastoname
            8 -> list09_miasto.text = miastoname
            9 -> list10_miasto.text = miastoname
            10 -> list11_miasto.text = miastoname
            11 -> list12_miasto.text = miastoname
            12 -> list13_miasto.text = miastoname
            13 -> list14_miasto.text = miastoname
            14 -> list15_miasto.text = miastoname
            15 -> list16_miasto.text = miastoname
            }
        }
        input_miasto_name.setText("Miasto 1")


        ZmianaWybranegoMisata(0)

        button_miasto_next.setOnClickListener(){
            ZmianaWybranegoMisata(1)
        }
        button_miasto_prev.setOnClickListener(){
            ZmianaWybranegoMisata(-1)
        }



    }
}