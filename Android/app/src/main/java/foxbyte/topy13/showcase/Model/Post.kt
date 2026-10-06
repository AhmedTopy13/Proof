package foxbyte.topy13.showcase.Model

import retrofit2.http.GET

data class Post (
    val id : Int,
    val userId : Int,
    val title : String ,
    val body : String ,
)

interface PostGetter {
    @GET("posts")
    suspend fun getPost(): PostsList
//    suspend fun getPost(): List<Post>
}

data class PostsList(
    val posts: List<Post>
)