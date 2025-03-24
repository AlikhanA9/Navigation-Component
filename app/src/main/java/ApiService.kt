package data

import FactBackResponse
import com.example.myapplicationnn.FactBackMemes
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v2/facts/random")
    suspend fun getFact(): FactBackResponse
    @GET("/get_memes")
    suspend fun getMemes(): FactBackMemes
}
