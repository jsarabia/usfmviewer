package api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DsmLanguageCatalog(
        val direction: String,
        val identifier: String,
        val title: String,
        val resources: List<DsmResourceCatalog>
)