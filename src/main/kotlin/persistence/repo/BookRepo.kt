package persistence.repo

//class BookRepo : Dao<Book> {
//
//    override fun insert(book: Book) : Int {
//        lateinit var ent: BookEntity
//        transaction {
//            ent = BookEntity.new {
//                name = book.name
//                slug = book.slug
//            }
//        }
//        return ent.id.value
//    }
//
//    override fun getById(id: Int) : Book {
//        lateinit var bke: BookEntity
//        transaction {
//            bke = BookEntity.get(id)
//        }
//        return Book(id = bke.id.value, slug = bke.slug, name = bke.name)
//    }
//
//    override fun getAll() : List<Book> {
//        lateinit var books : Iterable<BookEntity>
//        transaction { books = BookEntity.all() }
//        return books.map { Book(it.slug, it.name, it.id.value) }
//    }
//
//    override fun update(book: Book) {
//        var bke = getById(book.id)
//        transaction {
//            bke.name = book.name
//            bke.slug = book.slug
//        }
//    }
//}