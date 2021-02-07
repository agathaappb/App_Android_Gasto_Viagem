package com.agathaappb.calcgastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id

        if (id === R.id.buttonCalc) {
            calcular()
        }

    }

    private fun calcular() {
        if (validacaoOK()) {
            try {
                val dist = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editKmslitro.text.toString().toFloat()

                val valor = (dist * preco) / autonomia
                valResult.text = "R$ ${"%.2f".format(valor)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.info_valor_correto), Toast.LENGTH_LONG)
                    .show()
            }

        } else
            Toast.makeText(this, getString(R.string.preencha_tudo), Toast.LENGTH_LONG).show()

    }

    private fun validacaoOK(): Boolean {
        return (editDistancia.text.toString() != "" && editPreco.text.toString() != "" && editKmslitro.text.toString() != "" && editKmslitro.text.toString() != "0")

    }

}