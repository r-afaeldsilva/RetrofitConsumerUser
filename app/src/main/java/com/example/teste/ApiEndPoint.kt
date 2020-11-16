package com.example.teste
import com.example.teste.dominio.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiEndPoint {

        @GET("users")
        fun obterUsuarios(): Call<List<User>>
    }

