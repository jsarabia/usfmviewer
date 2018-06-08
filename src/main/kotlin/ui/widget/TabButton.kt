package ui.widget

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.ContentDisplay
import javafx.scene.paint.Paint
import tornadofx.*
import javax.swing.Icon

class TabButton(val text: String, val tabIcon: Node): Fragment() {
    override val root = stackpane {
            button(
                    text,
                    tabIcon
            ).style {
                contentDisplay = ContentDisplay.TOP
                alignment = Pos.TOP_RIGHT
                fontSize = .75.em
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#002b36")))
                textFill = Paint.valueOf("#FFFFFF")
                minWidth = 15.mm
            }
            rectangle {
                width = 4.0
                height = 45.0
                fill = Paint.valueOf("#BABABA")
                arcWidth = 5.0
                arcHeight = 5.0
                alignment = Pos.CENTER_LEFT
            }
            minWidth = 45.0
        }
}