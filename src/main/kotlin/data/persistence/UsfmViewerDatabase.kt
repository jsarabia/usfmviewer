package data.persistence

import data.Language
import data.dao.Dao

interface UsfmViewerDatabase {
//    fun getBookDao() : Dao<Book>
    fun getLanguageDao() : Dao<Language>
}