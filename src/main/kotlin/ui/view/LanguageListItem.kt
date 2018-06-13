package ui.view

import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import tornadofx.*

class LanguageListItem(name: String, slug: String) : HBox() {
    init {
        with(this) {
            text {
                text = name
                id = "languageName"
            }
            //fills region between name and slug
            region {
                hgrow = Priority.ALWAYS
            }
            text {
                text = slug
                id = "languageSlug"
            }

            style {
                fitToParentWidth()
            }
        }
    }
}