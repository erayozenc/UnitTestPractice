package com.example.unittestpractice

import com.example.unittestpractice.response.PostsResponse
import com.example.unittestpractice.response.PostsResponseItem
import retrofit2.Response
import retrofit2.http.*

interface JSONPlaceHolderService {

    @GET("/posts")
    fun getPosts() : PostsResponse

    @GET("/posts/{id}")
    fun getPost(
        @Path("id") id: String
    ) : PostsResponseItem

    @Headers("Content-type: application/json; charset=UTF-8")
    @POST("/post")
    fun savePost(
        title: String,
        body: String,
        userId: Int
    ) : Response<PostsResponseItem>
}