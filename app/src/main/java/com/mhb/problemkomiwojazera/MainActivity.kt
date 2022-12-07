package com.mhb.problemkomiwojazera

import android.nfc.Tag
import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class Vertex(val NumOVer : Int) {
    val Connections: IntArray = IntArray(NumOVer)
    var ConnectedTo: IntArray = IntArray(0)
    var Data = ""

    fun Connect(to : Int, weight : Int){
        if(to >= 0 && to<=Connections.size){
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

        val list01 : LinearLayout = findViewById(R.id.list01)
        val list02 : LinearLayout = findViewById(R.id.list02)
        val list03 : LinearLayout = findViewById(R.id.list03)
        val list04 : LinearLayout = findViewById(R.id.list04)
        val list05 : LinearLayout = findViewById(R.id.list05)
        val list06 : LinearLayout = findViewById(R.id.list06)
        val list07 : LinearLayout = findViewById(R.id.list07)
        val list08 : LinearLayout = findViewById(R.id.list08)
        val list09 : LinearLayout = findViewById(R.id.list09)
        val list10 : LinearLayout = findViewById(R.id.list10)
        val list11 : LinearLayout = findViewById(R.id.list11)
        val list12 : LinearLayout = findViewById(R.id.list12)
        val list13 : LinearLayout = findViewById(R.id.list13)
        val list14 : LinearLayout = findViewById(R.id.list14)
        val list15 : LinearLayout = findViewById(R.id.list15)
        val list16 : LinearLayout = findViewById(R.id.list16)

        val text_process : TextView = findViewById(R.id.textview_process)
        val button_save : Button = findViewById(R.id.button_zapisz)
        val button_search : Button = findViewById(R.id.button_szukaj)
        val button_random : Button = findViewById(R.id.button_losuj)
        val text_wynik: TextView = findViewById(R.id.textview_wynik)

        val Macierz = Matrix(16)
        Macierz.CreateVerticies()
        //Toast.makeText(applicationContext, Macierz.Verticies.size.toString(), Toast.LENGTH_SHORT).show()

        var WybraneMiasto = 0

        var powtorzeniacyklu=0

        var n = 16
        var v0=0
        var d=0
        var dH = 0
        var S = ArrayDeque<Int>()
        var SH = ArrayDeque<Int>()
        var Visited= BooleanArray(n)

        for(i in 0..15){
            Visited[i]=false
        }
        fun CyklHamiltona(v :Int){

            powtorzeniacyklu++
            Log.i("Cykl ",  powtorzeniacyklu.toString()+" V:"+v.toString())

            SH.add(v)

            if(SH.size!=n){
                Visited[v]=true
                for(u in 0..15){
                    if(Macierz.Verticies[v].Connections[u]==0){
                        continue
                    }
                    if(Visited[u]==true){
                        continue
                    }
                    dH=dH+Macierz.Verticies[v].Connections[u]
                    CyklHamiltona(u)
                    dH=dH-Macierz.Verticies[v].Connections[u]
                }
                Visited[v]=false

            }else{
                if(Macierz.Verticies[v].Connections[v0]!=0){
                    dH=dH+Macierz.Verticies[v].Connections[v0]
                    if(!(dH>=d)){
                        d=dH
                        S=SH
                    }
                    dH=dH-Macierz.Verticies[v].Connections[v0]
                }
            }
            SH.removeFirst()
        }
        
        
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

            list01.visibility = View.VISIBLE
            list02.visibility = View.VISIBLE
            list03.visibility = View.VISIBLE
            list04.visibility = View.VISIBLE
            list05.visibility = View.VISIBLE
            list06.visibility = View.VISIBLE
            list07.visibility = View.VISIBLE
            list08.visibility = View.VISIBLE
            list09.visibility = View.VISIBLE
            list10.visibility = View.VISIBLE
            list11.visibility = View.VISIBLE
            list12.visibility = View.VISIBLE
            list13.visibility = View.VISIBLE
            list14.visibility = View.VISIBLE
            list15.visibility = View.VISIBLE
            list16.visibility = View.VISIBLE

            when(WybraneMiasto){
                0 ->list01.visibility = View.GONE
                1 ->list02.visibility = View.GONE
                2 ->list03.visibility = View.GONE
                3 ->list04.visibility = View.GONE
                4 ->list05.visibility = View.GONE
                5 ->list06.visibility = View.GONE
                6 ->list07.visibility = View.GONE
                7 ->list08.visibility = View.GONE
                8 ->list09.visibility = View.GONE
                9 ->list10.visibility = View.GONE
                10 ->list11.visibility = View.GONE
                11 ->list12.visibility = View.GONE
                12 ->list13.visibility = View.GONE
                13 ->list14.visibility = View.GONE
                14 ->list15.visibility = View.GONE
                15 ->list16.visibility = View.GONE
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


        fun WyswietlaneOdleglosci(){

            list01_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[0].toString())
            list02_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[1].toString())
            list03_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[2].toString())
            list04_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[3].toString())
            list05_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[4].toString())
            list06_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[5].toString())
            list07_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[6].toString())
            list08_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[7].toString())
            list09_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[8].toString())
            list10_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[9].toString())
            list11_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[10].toString())
            list12_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[11].toString())
            list13_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[12].toString())
            list14_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[13].toString())
            list15_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[14].toString())
            list16_weight.setText(Macierz.Verticies[WybraneMiasto].Connections[15].toString())
        }//Zmiana Wyswietlania odleglosci

        ZmianaWybranegoMisata(0)

        button_miasto_next.setOnClickListener(){
            ZmianaWybranegoMisata(1)
            WyswietlaneOdleglosci()
        }
        button_miasto_prev.setOnClickListener(){
            ZmianaWybranegoMisata(-1)
            WyswietlaneOdleglosci()
        }


        WyswietlaneOdleglosci()

        fun ConnectWith(From :Int, To:Int, Weight:Int){
            if(From!=To){
                if(Weight>0){
                    Macierz.Verticies[From].Connect(To,Weight)
                }
            }
        }

        button_random.setOnClickListener(){
            var RandomWeight = 0
            for(x in 0..15){
                for(z in 0..15){
                    RandomWeight = Random.nextInt(1,100)
                    ConnectWith(x,z,RandomWeight)
                    ConnectWith(z,x,RandomWeight)
                }
            }
            WyswietlaneOdleglosci()
        }

        fun ConnectCity(To:Int,Weight :String){
            var Weight2=-1

            if(Weight!=""){
                Weight2=Integer.parseInt(Weight)
            }
            if(Weight2!=-1 && Weight2!=0){
                ConnectWith(WybraneMiasto, To, Weight2)
                ConnectWith(To, WybraneMiasto, Weight2)
                //Toast.makeText(applicationContext, "Utworzono połączenie o wadze: "+Weight2.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        list01_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(0,list01_weight.text.toString())

            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list02_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(1,list02_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list03_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(2,list03_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list04_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(3,list04_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list05_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(4,list05_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list06_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(5,list06_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list07_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(6,list07_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list08_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(7,list08_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list09_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(8,list09_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list10_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(9,list10_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list11_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(10,list11_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list12_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(11,list12_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list13_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(12,list13_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list14_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(13,list14_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list15_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(14,list15_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        list16_weight.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                ConnectCity(15,list16_weight.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        button_search.setOnClickListener(){
            var Check=true
            for(x in 0..15){
                for(z in 0..15){
                    if(x!=z){
                        if(Macierz.Verticies[x].Connections[z]==0){
                            Check=false
                            break
                        }
                    }
                }
            }
            if(!Check){
                Toast.makeText(applicationContext, "Brak połączenia", Toast.LENGTH_SHORT).show()
            }else{
                while(S.isEmpty()==false){
                    S.removeFirst()
                }
                while(SH.isEmpty()==false){
                    SH.removeFirst()
                }
                for(i in 0..15){
                    Visited[i]=false
                }
                d=999999999
                dH=0

                CyklHamiltona(0)
                if(S.isEmpty()==false){
                    Toast.makeText(applicationContext, "Cos Znaleziono!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "xdxdxdxd brak cykluuu xdxddd!", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}