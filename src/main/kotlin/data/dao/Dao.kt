package data.dao

interface Dao<T> {
    fun insert(obj: T) : Int
    fun getById(id: Int) : T
    fun update(obj: T)
}