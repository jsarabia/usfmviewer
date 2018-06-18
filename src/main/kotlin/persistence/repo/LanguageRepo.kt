package persistence.repo

import data.Language
import data.dao.Dao
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.exposed.sql.transactions.transaction
import persistence.model.LanguageEntity

class LanguageRepo : Dao<Language> {

    override fun insert(language: Language): Observable<Int> =
            Observable.just(
                    transaction {
                        LanguageEntity.new {
                            name = language.name
                            slug = language.slug
                            ang = language.ang
                            direction = language.direction
                        }
                    }.id.value
            ).subscribeOn(Schedulers.io())

    override fun getById(id: Int): Observable<Language> =
            Observable.just(
                    {
                        val le = transaction {
                            LanguageEntity.get(id)
                        }
                        Language(id = le.id.value, slug = le.slug, name = le.name, ang = le.ang, direction = le.direction)
                    }.invoke()
            ).subscribeOn(Schedulers.io())

    override fun getAll(): Observable<List<Language>> =
            Observable.just(
                    {
                        val languages = transaction { LanguageEntity.all() }.toList()
                        languages.map { Language(it.slug, it.ang, it.name, it.direction, it.id.value) }
                    }.invoke()
            ).subscribeOn(Schedulers.io())


    override fun update(language: Language): Completable =
            Completable.fromAction(
                    {
                        var le = getById(language.id).subscribe {
                            transaction {
                                it.name = language.name
                                it.slug = language.slug
                                it.direction = language.direction
                                it.ang = language.ang
                            }
                        }
                    }
            ).subscribeOn(Schedulers.io())
}