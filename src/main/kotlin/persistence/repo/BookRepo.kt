package persistence.repo

import data.Book
import data.dao.Dao
import org.jetbrains.exposed.sql.transactions.transaction
import persistence.model.BookEntity

class BookRepo : Dao<Book> {

    override fun insert(book: Book) : Int {
        lateinit var ent: BookEntity
        transaction {
            ent = BookEntity.new {
                name = book.name
                slug = book.slug
            }
        }
        return ent.id.value
    }

    override fun getById(id: Int) : Book {
        lateinit var bke: BookEntity
        transaction {
            bke = BookEntity.get(id)
        }
        return Book(id = bke.id.value, slug = bke.slug, name = bke.name)
    }

    override fun update(book: Book) {
        var bke = getById(book.id)
        transaction {
            bke.name = book.name
            bke.slug = book.slug
        }
    }
}