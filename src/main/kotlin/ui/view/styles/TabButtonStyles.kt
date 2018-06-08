package ui.view.styles

import javafx.geometry.Pos
import javafx.scene.control.ContentDisplay
import javafx.scene.paint.Color
import tornadofx.*

class TabButtonStyles : Stylesheet() {
    companion object {
        val tabButton by cssclass()
        val selected by cssclass()
        val ic by cssclass()
        val root by cssclass()

        val iconFill = c("#b3c1c1") //icon fill
        val iconBackground = c("#002b36") //icon background
    }

    init {
        tabButton {
            contentDisplay = ContentDisplay.TOP
            alignment = Pos.CENTER
            fontSize = .75.em
            backgroundColor += iconBackground
            textFill = iconFill
            minWidth = 15.mm
        }
        ic {
            fill = iconFill
        }
        root {
            insets(2,2,2,2)
        }
        selected {
            padding = CssBox(0.px, 4.px, 0.px, 0.px)
            fill = Color.WHITE
        }
    }
}