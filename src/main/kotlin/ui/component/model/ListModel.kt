package ui.component.model

class ListModel<T>() {

    val list = mutableListOf<T>()

    fun addItem(t: T) {
        list.add(t)
    }
}