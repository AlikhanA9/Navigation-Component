package data

import FactBackResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v2/facts/random")
    suspend fun getFact(): FactBackResponse
}