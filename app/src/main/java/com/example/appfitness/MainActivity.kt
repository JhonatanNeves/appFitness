package com.example.appfitness

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //    private lateinit var btnImc: LinearLayout
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawId = R.drawable.icon_btn_imc,
                texStringId = R.string.bmi,
                color = Color.YELLOW
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawId = R.drawable.icon_btn1,
                texStringId = R.string.tmb,
                color = Color.GRAY
            )
        )
        //METODO IMPL VIA FUNCTIONS
        val adapter = MainAdapter(mainItems) { id ->
            when (id) {
                1 -> {
                    val intent = Intent(this@MainActivity, ImcActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    // abrir uma outra activity
                }
                3 -> {
                    // abrir uma outra activity
                }
                4 -> {
                    // abrir uma outra activity
                }
            }
        }

        //METODO IMPL VIA OBJETO ANONIMO
//        val adapter = MainAdapter(mainItems, object : OnItemClickListener {
//            override fun onClick(id: Int) {
//                when (id) {
//                    1 -> {
//                        val intent = Intent(this@MainActivity, ImcActivity::class.java)
//                        startActivity(intent)
//                    }
//                    2 -> {
        // abrir uma outra activity
//                    }
//                    3 -> {
        // abrir uma outra activity
//                    }
//                    4 -> {
        // abrir uma outra activity
//                    }
//                }
//            }
//        })
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 2)
    }

    private inner class MainAdapter(
        private val mainItems: List<MainItem>,
//        private val onItemClickListener: OnItemClickListener
        private val onItemClickListener: (Int) -> Unit,
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

        // layout XML (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // disparado toda vez que houver uma rolagem na tela e for necessario trocar de conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return mainItems.size
        }

        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: MainItem) {
                val img: ImageView = itemView.findViewById(R.id.item_img_icon)
                val name: TextView = itemView.findViewById(R.id.item_txt_name)
                val container: LinearLayout = itemView.findViewById(R.id.item_container_imc)

                img.setImageResource(item.drawId)
                name.setText(item.texStringId)
                container.setBackgroundColor(item.color)
                container.setOnClickListener {
                    //aqui ele é uma ref. função
                    onItemClickListener.invoke(item.id)

                    // aqui ele é uma ref. interface
                    // onItemClickListener.onClick(item.id)
                }
            }
        }
    }
}