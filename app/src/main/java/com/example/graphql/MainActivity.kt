package com.example.graphql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloCallback
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.Logger
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.graphql.apollo.ApolloInstance
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.lang.reflect.GenericArrayType


class MainActivity : AppCompatActivity() {

    private lateinit var client: ApolloClient
    private lateinit var user:UserByIdQuery.User



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        client=ApolloInstance().get()
        getUsersList()
        getUserById()
        deleteUser()
        updateUser()
        createUser()



    }

    //createUser
    private fun createUser() {
        client.mutate(CreateUserMutation("Bijay","bijay1243","bijay@gmail.com")).enqueue(object :ApolloCall.Callback<CreateUserMutation.Data>(){
            override fun onResponse(response: Response<CreateUserMutation.Data>) {

            }

            override fun onFailure(e: ApolloException) {
            }

        })

    }


    //updateUser
    private fun updateUser() {
        client.mutate(UpdateUserMutation("5","Bijay","bijay1243","bijay@gmail.com")).enqueue(object :ApolloCall.Callback<UpdateUserMutation.Data>(){
            override fun onResponse(response: Response<UpdateUserMutation.Data>) {
                Log.d("ONRESPONSE",response.data.toString())
            }

            override fun onFailure(e: ApolloException) {

            }


        })

    }

    //delete user by id
    private fun deleteUser() {
        client.mutate(DeleteUserMutation("5")).enqueue(object :ApolloCall.Callback<DeleteUserMutation.Data>(){
            override fun onResponse(response: Response<DeleteUserMutation.Data>) {
                Log.d("ONRESPONSE",response.data.toString())
            }

            override fun onFailure(e: ApolloException) {

            }


        })
    }



    //get user by id
    private fun getUserById() {
        client.query(UserByIdQuery("3")).enqueue(object :ApolloCall.Callback<UserByIdQuery.Data>(){
            override fun onResponse(response: Response<UserByIdQuery.Data>) {
                Log.d("ONRESPONSE",response.data.toString())
            }

            override fun onFailure(e: ApolloException) {

            }


        })
    }

    //get users list
    private fun getUsersList() {

            client.query(UsersListQuery()).enqueue(object :ApolloCall.Callback<UsersListQuery.Data>(){
                override fun onResponse(response: Response<UsersListQuery.Data>) {
                    Log.d("ONRESPONSE",response.data.toString())
                }

                override fun onFailure(e: ApolloException) {

                }


            })

    }




    }

