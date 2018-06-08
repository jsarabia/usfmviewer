package api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DsmResourceCatalog(
        //val checking: Transient,
        //val comment: String,
        //val contributors: List<String>,
        //val creator: String,
        //val description: String,
        //val formats: Transient,
        val identifier: String,
        //val issued: String,
        val modified: String,
        val projects: List<DsmProject>,
        //val publisher: String,
        //val relation: Transient,
        //val rights: String,
        //val source: Transient,
        //val subject: String,
        val title: String,
        val version: String
)

@JsonClass(generateAdapter = true)
data class DsmProject(
        //val categories: Transient,
        //val formats: Transient,
        val identifier: String,
        val sort: Int,
        val title: String,
        var versification: String?
)