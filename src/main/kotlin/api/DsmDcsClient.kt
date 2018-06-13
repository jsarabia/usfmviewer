package api

import api.model.DsmDcsCatalog
import io.reactivex.Observable
import retrofit2.http.GET

interface DsmDcsClient {
    @GET("/v2/catalog.json")
    fun catalog() : Observable<DsmDcsCatalog>
}