package persistence.repo

import data.Language
import data.dao.Dao
import data.persistence.UsfmViewerDatabase
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.sqlite.SQLiteDataSource
import persistence.model.Books
import persistence.model.Languages
import java.sql.Connection
import javax.inject.Singleton

@Singleton
class Db : UsfmViewerDatabase {

    val db = Database.connect("jdbc:sqlite:usfm.sqlite", "org.sqlite.JDBC")
    val source = SQLiteDataSource()
    val languageRepo = LanguageRepo()
//    val bookRepo = BookRepo()

    init {
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
        transaction {
            create(Books, Languages)
        }
        source.url = "jdbc:sqlite:sqlite.db"
    }

//    override fun getBookDao(): Dao<Book> {
//        return bookRepo
//    }

    override fun getLanguageDao(): Dao<Language> {
        return languageRepo
    }
}