package com.example.ultimagota

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    private lateinit var perguntaTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var proximaPerguntaButton: Button

    private val perguntas = mutableListOf(
        Pergunta("Qual é a recomendação diária de consumo de água para um adulto?",
            listOf("2 litros", "4 litros", "8 litros", "10 litros"),
            2 // Índice da resposta correta
        ),
        Pergunta("Quais dos seguintes itens consomem mais água em casa?",
            listOf("Lavar as mãos", "Tomar banho", "Lavar o carro", "Lavar louça"),
            3 // Índice da resposta correta
        ),
        Pergunta("Qual é a principal razão para conservar água?",
            listOf("Reduzir as contas de água", "Preservar o meio ambiente", "Ter água quente mais tempo", "Ficar mais saudável"),
            1 // Índice da resposta correta
        ),
        Pergunta("Quanto tempo você deve deixar a torneira aberta enquanto escova os dentes?",
            listOf("30 segundos", "1 minuto", "5 minutos", "Não deixar aberta"),
            3 // Índice da resposta correta
        ),
        Pergunta("Qual é a porcentagem de água em nosso corpo?",
            listOf("10%", "30%", "50%", "70%"),
            3 // Índice da resposta correta
        ),
        Pergunta("Qual é a importância de se economizar água?",
            listOf("Manter a pele saudável", "Conservar o dinheiro", "Preservar o meio ambiente", "Ficar famoso"),
            2 // Índice da resposta correta
        ),
        Pergunta("Qual a principal causa do desperdício de água em uma casa?",
            listOf("Banho longo", "Lavar as mãos", "Lavar louça", "Vazamentos"),
            3 // Índice da resposta correta
        ),
        Pergunta("Qual é a temperatura ideal da água para tomar banho?",
            listOf("Água fria", "Água morna", "Água quente", "Água gelada"),
            1 // Índice da resposta correta
        )
    )

    private var perguntaAtualIndex = 0
    private var pontuacao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val voltarButton = findViewById<Button>(R.id.voltarButton)

        voltarButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        perguntaTextView = findViewById(R.id.perguntaTextView)
        radioGroup = findViewById(R.id.radioGroup)
        proximaPerguntaButton = findViewById(R.id.proximaPerguntaButton)

        proximaPerguntaButton.setOnClickListener {
            verificarResposta()
        }

        exibirPerguntaAtual()
    }

    private fun exibirPerguntaAtual() {
        if (perguntaAtualIndex < perguntas.size) {
            val perguntaAtual = perguntas[perguntaAtualIndex]
            perguntaTextView.text = perguntaAtual.pergunta
            radioGroup.removeAllViews()

            for ((index, opcao) in perguntaAtual.opcoes.withIndex()) {
                val radioButton = RadioButton(this)
                radioButton.text = opcao
                radioButton.id = index
                radioGroup.addView(radioButton)
            }
        } else {
            // Todas as perguntas foram respondidas
            Toast.makeText(this, "Pontuação: $pontuacao", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verificarResposta() {
        val respostaSelecionadaId = radioGroup.checkedRadioButtonId

        if (respostaSelecionadaId != -1) {
            val perguntaAtual = perguntas[perguntaAtualIndex]
            if (respostaSelecionadaId == perguntaAtual.respostaCorreta) {
                pontuacao++
            }

            perguntaAtualIndex++
            exibirPerguntaAtual()
        } else {
            Toast.makeText(this, "Selecione uma resposta.", Toast.LENGTH_SHORT).show()
        }
    }


}

data class Pergunta(val pergunta: String, val opcoes: List<String>, val respostaCorreta: Int)

