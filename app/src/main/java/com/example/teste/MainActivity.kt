package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.teste.dominio.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscaDados();
    }
    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterUsuarios()?.enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>?>?, response: Response<List<User>?>?) {
                val lista = response?.body();
                if (lista != null) {
                    for (user in lista) {
                        Log.d("Resposta", user.email.toString())
                    }
                }

                rv_contact_list.recycledViewPool.setMaxRecycledViews(0, 0)
                rv_contact_list.adapter= lista?.let { ContactListAdapter(it) }

            }

            override fun onFailure(call: Call<List<User>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })
    }

}