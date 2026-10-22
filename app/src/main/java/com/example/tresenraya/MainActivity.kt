package com.example.tresenraya

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tresenraya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding : ActivityMainBinding

    private var turno = false
    private var partidaActiva = false

    private var movimientos = 0

    private lateinit var botones: List<androidx.appcompat.widget.AppCompatButton>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botones = listOf(
            binding.bt11, binding.bt12, binding.bt13,
            binding.bt21, binding.bt22, binding.bt23,
            binding.bt31, binding.bt32, binding.bt33,
        )

        setMyListener()
        iniciarPartida()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setMyListener(){

        botones.forEach { it.setOnClickListener(this) }
        binding.btreset.setOnClickListener(this)

    }

    override fun onClick(boton: View?) {
        if (boton == null) return

        if (boton == binding.btreset) {
            reiniciarPartida()
            return
        }

        if (!partidaActiva) return

        val botonPulsado = boton as androidx.appcompat.widget.AppCompatButton
        if (botonPulsado.text.isEmpty()) {
            if (!turno) {
                botonPulsado.text = getString(R.string.celdaX)
                botonPulsado.setTextColor(getColor(R.color.color_x))
                turno = true
            } else {
                botonPulsado.text = getString(R.string.celdaO)
                botonPulsado.setTextColor(getColor(R.color.color_o))
                turno = false
            }

            movimientos++
            actualizarPartida()
        }
    }

    // REINICIA LA PARTIDA
    private fun reiniciarPartida() {
        iniciarPartida()
    }

    // REINICIA LAS CELDAS DEL TABLERO
    private fun limpiarTablero(){
        botones.forEach { it.text = "" }
    }

    // INICIA LA PARTIDA
    private fun iniciarPartida(){

        turno = false
        partidaActiva = true
        movimientos = 0
        binding.turno.text = getString(R.string.turnoX)
        limpiarTablero()

    }

    private fun hayGanador(): String? {
        // Recojo todos los datos de los botones
        val b11 = binding.bt11.text.toString()
        val b12 = binding.bt12.text.toString()
        val b13 = binding.bt13.text.toString()

        val b21 = binding.bt21.text.toString()
        val b22 = binding.bt22.text.toString()
        val b23 = binding.bt23.text.toString()

        val b31 = binding.bt31.text.toString()
        val b32 = binding.bt32.text.toString()
        val b33 = binding.bt33.text.toString()

        // COMPRUEBO SI HAY ALGUNA FILA COMPLETA
        if (b11.isNotEmpty() && b11 == b12 && b12 == b13) return b11
        if (b21.isNotEmpty() && b21 == b22 && b22 == b23) return b21
        if (b31.isNotEmpty() && b31 == b32 && b32 == b33) return b31

        // COMPRUEBO SI HAY ALGUNA COLUMNA COMPLETA
        if (b11.isNotEmpty() && b11 == b21 && b21 == b31) return b11
        if (b12.isNotEmpty() && b12 == b22 && b22 == b32) return b12
        if (b13.isNotEmpty() && b13 == b23 && b23 == b33) return b13

        // COMPRUEBO SI HAY ALGUNA DIAGONAL COMPLETA
        if (b11.isNotEmpty() && b11 == b22 && b22 == b33) return b11
        if (b13.isNotEmpty() && b13 == b22 && b22 == b31) return b13

        return null
    }

    private fun actualizarPartida(){

        val ganador = hayGanador()

        if (ganador != null){
            partidaActiva = false
            if(ganador == getString(R.string.celdaX)) binding.turno.text = getString(R.string.ganadorX)
            else  binding.turno.text = getString(R.string.ganadorO)
        }else if (movimientos == 9){
            partidaActiva = false
            binding.turno.text = getString(R.string.empate)
        }else{
            if(!turno) binding.turno.text = getString(R.string.turnoX)
            else binding.turno.text = getString(R.string.turnoO)
        }
    }


}