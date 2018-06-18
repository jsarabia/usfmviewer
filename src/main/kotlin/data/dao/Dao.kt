package data.dao

import io.reactivex.Completable
import io.reactivex.Observable

interface Dao<T> {
    fun insert(obj: T) : Observable<Int>
    fun getById(id: Int) : Observable<T>
    fun getAll() : Observable<List<T>>
    fun update(obj: T) : Completable
}