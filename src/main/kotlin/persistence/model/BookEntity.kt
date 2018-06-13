package persistence.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable


object Books : IntIdTable() {
    val slug = varchar("slug", 50)
    val name = varchar("name", 50)

    init {
        index(true, slug, name)
    }
}

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(Books)

    var slug by Books.slug
    var name by Books.name
}