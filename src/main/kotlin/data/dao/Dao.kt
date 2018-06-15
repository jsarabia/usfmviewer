package data.dao

interface Dao<T> {
    fun insert(obj: T) : Int
    fun getById(id: Int) : T
    fun getAll() : List<T>
    fun update(obj: T)
}