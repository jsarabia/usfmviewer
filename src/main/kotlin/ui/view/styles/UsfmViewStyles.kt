package ui.view.styles

import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class UsfmViewStyles : Stylesheet() {
    companion object {
        val root by cssclass()
        val tabPane by cssclass()
        val textArea by cssclass()

        val textColor = c("BABABA")
        val textAreaBackground = c("#222324")
        val tabPaneBackground = c("#244e66")
    }

    init {
        tabPane {
            backgroundColor += tabPaneBackground
            padding = CssBox(4.px, 2.px, 1.px, 1.px)
            spacing = 8.px
        }
        textArea {
            baseColor = Color.TRANSPARENT
            backgroundColor += textAreaBackground
            wrapText = true
            font = Font.font("monaco", FontWeight.BOLD, 9.0)
            textFill = textColor
        }
    }
}