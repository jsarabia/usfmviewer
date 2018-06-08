package persistence.repo

import data.Language
import data.dao.Dao
import persistence.model.LanguageEntity

class LanguageRepo : Dao<Language> {

    override fun insert(language: Language) : Int {
        val lang =  LanguageEntity.new {
            name = language.name
            slug = language.slug
            ang = language.ang
            direction = language.direction
        }
        return lang.id.value
    }

    override fun getById(id: Int) : Language {
        val le = LanguageEntity.get(id)
        return Language(id = le.id.value, slug = le.slug, name = le.name, ang = le.ang, direction = le.direction)
    }

    override fun update(language: Language) {
        var le = getById(language.id)
        le.name = language.name
        le.slug = language.slug
        le.direction = language.direction
        le.ang = language.ang
    }
}