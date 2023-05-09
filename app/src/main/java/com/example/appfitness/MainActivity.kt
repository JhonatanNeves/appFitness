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

class MainActivity : AppCompatActivity(), OnItemClickListener {

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
                texStringId = R.string.imc,
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
        mainItems.add(
            MainItem(
                id = 3,
                drawId = R.drawable.icon_btn,
                texStringId = R.string.app_name,
                color = Color.DKGRAY
            )
        )
        mainItems.add(
            MainItem(
                id = 4,
                drawId = R.drawable.icon_btn,
                texStringId = R.string.app_name,
                color = Color.CYAN
            )
        )

        val adapter = MainAdapter(mainItems, this)
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 2)
    }


    override fun onClick() {
        Log.i("Teste", "clicou!")
    }

    private inner class MainAdapter(
        private val mainItems: List<MainItem>,
        private val onItemClickListener: OnItemClickListener
    ) :
        RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

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
                    onItemClickListener.onClick()
                }
            }
        }
    }
}