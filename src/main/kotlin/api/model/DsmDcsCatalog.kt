package api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DsmDcsCatalog(
        //val catalogs: Transient,
        val languages: List<DsmLanguageCatalog>
)