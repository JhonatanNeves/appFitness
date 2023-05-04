package com.example.appfitness

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
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
                drawId = R.drawable.icon_btn,
                texStringId = R.string.imc,
                color = Color.GRAY
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawId = R.drawable.icon_btn,
                texStringId = R.string.tmb,
                color = Color.GRAY
            )
        )

        val adapter = MainAdapter(mainItems)
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

//        btnImc = findViewById(R.id.btn_imc)
//
//        btnImc.setOnClickListener{
//            val i = Intent(this, ImcActivity::class.java)
//            startActivity(i)
//        }
    }

    private inner class MainAdapter(private val mainItems: List<MainItem>) :
        RecyclerView.Adapter<MainViewHolder>() {

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

    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MainItem) {
            val buttonTest: Button = itemView.findViewById(R.id.btn_item)
            buttonTest.setText(item.texStringId)
        }
    }

}