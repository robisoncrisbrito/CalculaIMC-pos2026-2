package br.edu.utfpr.calculaimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)

        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }

        btCalcular.setOnLongClickListener {
            Toast.makeText(this, getString(R.string.msg_longclick_calcular), Toast.LENGTH_SHORT).show()
            true
        }

        btLimpar.setOnLongClickListener {
            Toast.makeText(this, getString(R.string.msg_longclick_limpar), Toast.LENGTH_SHORT).show()
            true
        }

    } //fim do método onCreate()

     fun btCalcularOnClick() {
        //entrada
        var resultado: Double

        val peso = etPeso.text.toString().toDoubleOrNull()?: run {
            etPeso.error = getString(R.string.erro_peso)
            etPeso.requestFocus()
            return
        }

        val altura = etAltura.text.toString().toDoubleOrNull()?: run {
            etAltura.error = getString(R.string.erro_altura)
            etAltura.requestFocus()
            return
        }

        //processamento

        resultado = peso / altura.pow(2)

        //saída
        tvResultado.text = "%.2f".format(resultado)

    }

    private fun btLimparOnClick() {
        etPeso.text.clear()
        etAltura.text.clear()
        tvResultado.text = getString(R.string.zeros)
        etPeso.requestFocus()
    }

} //fim da classe MainActivity