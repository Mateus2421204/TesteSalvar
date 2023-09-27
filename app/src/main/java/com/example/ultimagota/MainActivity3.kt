package com.example.ultimagota

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var tempoDoBanho: EditText
    private lateinit var resultadoMensagem: TextView
    private lateinit var botaoCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        tempoDoBanho = findViewById(R.id.tempoDoBanho)
        resultadoMensagem = findViewById(R.id.resultadoBanho)
        botaoCalcular = findViewById(R.id.botaoCalcular)

        botaoCalcular.setOnClickListener {
            determinarTipoDeBanho()
        }
    }

    private fun determinarTipoDeBanho() {
        val valorDigitado = tempoDoBanho.text.toString()

        if (!valorDigitado.isEmpty()) {
            try {
                val tempoEmMinutos = valorDigitado.toFloat()

                if (tempoEmMinutos >= 5 && tempoEmMinutos < 15) {
                    // Banho curto
                    resultadoMensagem.text = "Parabéns! Você tomou um banho curto. Muitas pessoas tomam banhos rápidos de 5 a 10 minutos. Isso envolve o básico, como ensaboar o corpo, lavar o cabelo e enxaguar.  "
                } else if (tempoEmMinutos >= 15 && tempoEmMinutos <= 20) {
                    // Banho médio
                    resultadoMensagem.text = "Seu banho foi de duração média. Um banho médio pode levar de 15 a 20 minutos. Isso inclui o tempo para lavar o corpo, o cabelo e fazer uma limpeza mais detalhada."
                } else if (tempoEmMinutos > 20) {
                    // Banho longo
                    resultadoMensagem.text = "Atenção! Seu banho foi longo. Economia de Água: É importante lembrar que banhos mais longos tendem a usar mais água. Se a conservação de água for uma preocupação, é recomendável limitar o tempo do banho e considerar instalar dispositivos de economia de água, como chuveiros de baixo consumo."
                }
            } catch (e: NumberFormatException) {
                resultadoMensagem.text = "Digite um valor válido para o tempo de banho."
            }
        } else {
            resultadoMensagem.text = "Digite o tempo de banho."
        }
    }
}

