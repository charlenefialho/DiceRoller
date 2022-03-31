package com.ds.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val toast = Toast.makeText(this, "rolou o dado!", Toast.LENGTH_SHORT)
                .show()//toast é como se fosse o window.alert
            val resultTextView: TextView = findViewById(R.id.textView) //sempre dar import
            rollDice()
        }

    }

//criação de classe

    class Dice(private val numSides: Int) {    //Dice = dado (//atributos ) class dice(parametros)
        //metódos
        fun roll(): Int {
            val numero = (1..numSides).random()   // 1 até numero de lados
            return (numero)
        }
    }

    //metódo para gerenciar quando o usuario clicar no botao
//botao - activity main
    private fun rollDice() {
        val dice = Dice(6)          //instancia  a classe dice em objeto
        val diceRoll = dice.roll()   //variavel para guardar o numero sorteado  usando a função criada roll()
        val diceImage: ImageView = findViewById(R.id.imageView2)

        //when = switch
        /*when(diceRoll)
        {
            1 -> diceImage.setImageResource(R.drawable.dice_1)  //define imagem do drawable a ser exibida
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }*/

        // ------------------------------        otimizar   -------------------------

        val drawableResource = when (diceRoll)
        {
            1 -> R.drawable.dice_1  //define imagem do drawable a ser exibida
            2 ->R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 ->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}