package ui.component.view

import data.Book
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import tornadofx.*

class BookListItem(val book: Book) : HBox() {
    init {
        with(this) {
            text {
                text = book.name
                id = "bookName"
            }
            //fills region between name and slug
            region {
                hgrow = Priority.ALWAYS
            }
            text {
                text = book.slug
                id = "bookSlug"
            }
            style {
                fitToParentWidth()
            }
        }
    }
}