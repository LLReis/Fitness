package co.llreis.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private lateinit var btnImc: LinearLayout
      private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter()
        rvMain = findViewById(R.id.rv_main) //<-- padrão de pegar a referencia de itens sem a biblioteca bind"
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)
        //criar classe para administrar a recyclerview e suas celulas (os seus layouts de itens)
        //adapter

//        btnImc.setOnClickListener {
//            //navegar para a proxima tela
//            val i = Intent(this, ImcActivity::class.java) // << código padrão
//            startActivity(i)
//        }
    }

    private inner class MainAdapter : RecyclerView.Adapter<MainViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)

        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return 15
        }

    }

    // ↓↓↓ classe da celula em si!!
    private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)
}