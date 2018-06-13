package persistence.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable


object Languages : IntIdTable() {
    val slug = varchar("slug", 255)
    val name = varchar("name", 255)
    val ang = varchar("ang", 255)
    val direction = varchar("direction", 3) // ltr or rtl

    init {
        index(true, slug, name)
    }
}

class LanguageEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<LanguageEntity>(Languages)

    var slug by Languages.slug
    var name by Languages.name
    var ang by Languages.ang
    var direction by Languages.direction
}