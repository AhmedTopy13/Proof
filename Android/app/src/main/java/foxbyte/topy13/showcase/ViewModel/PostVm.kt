package foxbyte.topy13.showcase.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import foxbyte.topy13.showcase.Model.Post
import foxbyte.topy13.showcase.Model.PostGetter
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostVm : ViewModel() {
    private val retr = Retrofit.Builder()
        .baseUrl("http:dummyjson.com/")
//        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostGetter::class.java)
    var posts by mutableStateOf<List<Post>>(emptyList())
        private set
    var isLoad by mutableStateOf(false)
        private set
    var errorMsg by mutableStateOf<String?>(null)
        private set

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {
            isLoad = true
            errorMsg = null
            try {
                posts = retr.getPost().posts
            } catch (e: Exception) {
                errorMsg = e.message
            } finally {
                isLoad = false
            }
        }
    }
}