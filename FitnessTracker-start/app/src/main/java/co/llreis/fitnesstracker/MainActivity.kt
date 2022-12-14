package co.llreis.fitnesstracker

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RemoteViews
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


      private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.ic_baseline_wb_sunny_24,
                textStringId = R.string.label_imc,
                color = Color.GREEN
            )
        )

        val adapter = MainAdapter(mainItems)
        rvMain = findViewById(R.id.rv_main) //<-- padrão de pegar a referencia de itens sem a biblioteca bind"
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

    }

    private inner class MainAdapter(private  val mainItems: List<MainItem>) : RecyclerView.Adapter<MainViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)

        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)

        }

        override fun getItemCount(): Int {
            return mainItems.size
        }

    }

    // ↓↓↓ classe da celula em si!!
    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: MainItem) {
            val buttonTest: Button = itemView.findViewById(R.id.btn_item)
            buttonTest.setText(item.textStringId)
        }
    }
}