package api

import api.model.DsmDcsCatalog
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface DsmDcsClient {
    @GET("/v3/catalog.json")
    fun catalog() : Observable<DsmDcsCatalog>
}