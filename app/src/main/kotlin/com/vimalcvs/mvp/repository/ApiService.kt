package com.vimalcvs.mvp.repository

import com.vimalcvs.mvp.model.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/api.php?categories&api_key=cda11lHY0ZafN2nrti4U5QAKMDhTw7Czm1xoSsyVLduvRegkqE")
    suspend fun getCategories(): CategoryResponse

}
