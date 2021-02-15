package com.example.projek_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.detil_film.*

class DetilFilm : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detil_film)
        if (intent.hasExtra("judulnya")){
            val judul: String=this.intent.getStringExtra("judulnya").toString()
            val foto: String=this.intent.getStringExtra("fotonya").toString()
            val sinopsis: String=this.intent.getStringExtra("sinopsisnya").toString()
            val genre: String=this.intent.getStringExtra("genrenya").toString()
            val durasi: String=this.intent.getStringExtra("durasinya").toString()
            val sutradara: String=this.intent.getStringExtra("sutradaranya").toString()
            setDetil(foto,judul,sinopsis,genre,durasi,sutradara)
        }
    }
    fun setDetil(foto:String, judul:String, sinopsis:String, genre:String, durasi:String, sutradara:String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        judul_detil_film.text = judul
        sinopsis_film.text = sinopsis
        genre_film.text = genre
        durasi_film.text = durasi
        sutradara_film.text = sutradara
        Glide.with(this)
            .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(foto_detil)
    }
}