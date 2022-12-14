package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val borrarButton: Button = findViewById(R.id.borrarButton)
        val igualButton: Button = findViewById(R.id.igualButton)

        igualButton.setOnClickListener {
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(oper){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }
            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }
        borrarButton.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }

    }

    fun presionarDigito (view: View){

        //val tv_num2: TextView = findViewById(R.id.tv_num2)
        var num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.zeroButton -> tv_num2.setText(num2 + "0")
            R.id.unoButton -> tv_num2.setText(num2+"1")
            R.id.dosButton -> tv_num2.setText(num2 + "2")
            R.id.tresButton -> tv_num2.setText(num2 + "3")
            R.id.cuatroButton -> tv_num2.setText(num2+"4")
            R.id.cincoButton -> tv_num2.setText(num2 + "5")
            R.id.seisButton -> tv_num2.setText(num2 + "6")
            R.id.sieteButton -> tv_num2.setText(num2+"7")
            R.id.ochoButton -> tv_num2.setText(num2 + "8")
            R.id.nueveButton -> tv_num2.setText(num2 + "9")
            R.id.puntoButton -> tv_num2.setText(num2+".")

        }

    }

    fun clicOperacion(view: View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")

        when(view.id){
            R.id.sumaButton ->{
                tv_num1.setText(num2_text + "+")
                oper = 1
            }
            R.id.menosButton ->{
                tv_num1.setText(num2_text + "-")
                oper = 2
            }
            R.id.multiplicacionButton ->{
                tv_num1.setText(num2_text + "*")
                oper = 3
            }
            R.id.divisionButton ->{
                tv_num1.setText(num2_text + "/")
                oper = 4
            }

        }

    }
}