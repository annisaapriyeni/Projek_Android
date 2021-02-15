package com.example.projek_mobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_list_film.view.*

class FilmRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        private var items: List<ListObjFilm> = ArrayList()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return FilmViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_list_film,parent,
                    false)
            )
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder){
                is FilmViewHolder -> {
                    holder.bind(items.get(position))
                    holder.klik.setOnClickListener{
                        holder.kalau_diklik(items.get(position))
                    }
                }
            }
        }
        fun submitList(listFilm: List<ListObjFilm>){
            items = listFilm
        }
        override fun getItemCount(): Int {
            return items.size
        }
        class FilmViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
            val foto: ImageView = itemView.gambar_film
            val judul: TextView = itemView.judul
            val rating: TextView = itemView.rating
            val sinopsis: TextView = itemView.sinopsis
            val genre: TextView = itemView.genre
            val sutradara: TextView = itemView.sutradara
            val durasi: TextView = itemView.durasi
            var klik: RelativeLayout = itemView.findViewById(R.id.rl_klik)

            fun bind(listObjFilm: ListObjFilm){
                judul.setText(listObjFilm.judul)
                rating.setText(listObjFilm.rating)

                val  requestOp = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOp)
                    .load(listObjFilm.gambar)
                    .into(foto)
            }
            fun kalau_diklik(get: ListObjFilm){
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"Kamu memilih : ${get.judul}",
                    Toast.LENGTH_SHORT).show()

                val intent = Intent(itemView.context, DetilFilm::class.java)
                intent.putExtra("judulnya", get.judul)
                intent.putExtra("ratingnya", get.rating)
                intent.putExtra("fotonya", get.gambar)
                intent.putExtra("sinopsisnya", get.sinopsis)
                intent.putExtra("genrenya", get.genre)
                intent.putExtra("durasinya", get.durasi)
                intent.putExtra("sutradaranya", get.sutradara)
                itemView.context.startActivity(intent)
            }
        }
    }
