package ui.view

import com.jfoenix.controls.JFXListView
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import tornadofx.*

class LanguageDrawer : VBox() {

    val languageList = JFXListView<LanguageListItem>()
    val searchField = TextField()

    init {
        with(this) {
            text {
                id = "title"
                text = "Language"
                style {
                    fontSize = 2.em
                    alignment = Pos.CENTER
                }
            }

            this += searchField.apply {
                text = "Search..."
            }

            this += languageList.apply {
                id = "languageList"
                style {
                    vgrow = Priority.ALWAYS
                    fitToParentHeight()
                }
            }
        }

        for (i in 1..100) {
            addLanguage("English", "en")
        }
    }

    fun addLanguage(name: String, slug: String) {
        languageList.items.add(LanguageListItem(name, slug))
    }
}