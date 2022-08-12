package co.llreis.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var btnImc: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnImc = findViewById(R.id.btnImc)

        btnImc.setOnClickListener {
            //navegar para a proxima tela
            val i = Intent(this, ImcActivity::class.java) // << código padrão
            startActivity(i)
        }
    }
}