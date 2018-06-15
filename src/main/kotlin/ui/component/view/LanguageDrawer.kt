package ui.component.view

import com.github.thomasnield.rxkotlinfx.actionEvents
import com.jfoenix.controls.JFXListView
import data.Language
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import tornadofx.*
import tornadofx.FX.Companion.messages
import ui.component.viewmodel.SearchListViewModel

class LanguageDrawer : VBox() {

    val viewModel = SearchListViewModel()

    val languageList = JFXListView<LanguageListItem>()
    val searchField = TextField()

    init {
        with(this) {
            text {
                id = "title"
                text = messages["language"].capitalize()
                style {
                    fontSize = 2.em
                    alignment = Pos.CENTER
                }
            }

            this += searchField.apply {
                text = "${messages["search"].capitalize()}..."
                onMouseClicked = EventHandler { text = "" }
            }

            this += languageList.apply {
                id = "languageList"
                style {
                    vgrow = Priority.ALWAYS
                    fitToParentHeight()
                }
            }
        }

        searchField.actionEvents()
                .subscribe({ println("text changed")})

        for (i in 1..100) {
            addLanguage(Language("en", "English", "English", "ltr"))
        }
    }

    fun addLanguage(language: Language) {
        languageList.items.add(LanguageListItem(language))
    }
}