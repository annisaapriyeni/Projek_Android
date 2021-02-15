package com.example.projek_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_film.*

    class MainActivity : AppCompatActivity() {
        private lateinit var filmAdapter: FilmRecyclerAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_film)
            initRecyclerView()
            tambahDataSet()
        }
        private fun tambahDataSet(){
            val data = SumberData.buatSetData()
            filmAdapter.submitList(data)
        }
        private fun initRecyclerView(){
            recycler_view.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                val spacingAtas = DekorasiSpasiGambar(20)
                addItemDecoration(spacingAtas)
                filmAdapter = FilmRecyclerAdapter()
                adapter = filmAdapter
            }
        }
    }
