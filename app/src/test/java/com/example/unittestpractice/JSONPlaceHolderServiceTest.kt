package com.example.unittestpractice

import com.example.unittestpractice.response.PostsResponseItem
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import com.google.common.truth.Truth.assertThat
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class JSONPlaceHolderServiceTest {

    private lateinit var expectedItem : PostsResponseItem

    private lateinit var savedItem : Response<PostsResponseItem>

    @Mock
    lateinit var service: JSONPlaceHolderService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        expectedItem = PostsResponseItem(
            body = "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            id = 1,
            userId = 1
        )

        savedItem = Response.success(
            PostsResponseItem(
                body = "Body",
                title = "Title",
                id = 1,
                userId = 1
            )
        )

        whenever(service.getPost("1")).thenReturn(expectedItem)
        whenever(service.savePost(
            "Title",
            "Body",
            1
        )).thenReturn(savedItem)
    }

    @Test
    fun whenGetPostWithId1_returnBelowItem() {
        val actualItem = service.getPost("1")
        assertThat(actualItem).isEqualTo(expectedItem)
    }

    @Test
    fun whenSavePost_returnSameItem() {
        val actualItem = service.savePost("Title", "Body", 1)
        assertThat(actualItem).isEqualTo(savedItem)
    }


}