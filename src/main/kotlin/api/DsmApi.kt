package api

import api.model.DsmDcsCatalog
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

//const val DSM_API_BASE_URL = "https://api.door43.org"
const val DSM_API_BASE_URL = "http://poc-api.door43.org.s3.amazonaws.com"


class DsmApi {

    var dsmClient: DsmDcsClient

    init {
        val httpClient = OkHttpClient.Builder()
        val builder =
                Retrofit.Builder()
                        .baseUrl(DSM_API_BASE_URL)
                        .addConverterFactory(
                                MoshiConverterFactory.create()
                        ).addCallAdapterFactory(
                                RxJava2CallAdapterFactory.create()
                        )

        val retrofit =
                builder
                        .client(
                                httpClient.build()
                        ).build()
        dsmClient = retrofit.create(DsmDcsClient::class.java)
    }

    fun getCatalog() : Observable<DsmDcsCatalog> {
        return dsmClient.catalog()
    }
}
