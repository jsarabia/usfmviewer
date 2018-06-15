package ui.component.view

import data.Language
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import tornadofx.*

class LanguageListItem(val language: Language) : HBox() {
    init {
        with(this) {
            text {
                text = language.name
                id = "languageName"
            }
            //fills region between name and slug
            region {
                hgrow = Priority.ALWAYS
            }
            text {
                text = language.slug
                id = "languageSlug"
            }
            style {
                fitToParentWidth()
            }
        }
    }
}