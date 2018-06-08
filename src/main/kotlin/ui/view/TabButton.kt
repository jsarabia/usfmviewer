package ui.view

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import tornadofx.*
import ui.view.styles.TabButtonStyles

class TabButton(val text: String, val ic: Node) : Fragment() {

    override val root: HBox by fxml()

    val tabButton: Button by fxid()
    val selected: Rectangle by fxid()

    init {
        tabButton.text = text
        tabButton.graphic = ic
        selected.isVisible = false

        addStyling()
    }

    private inline fun addStyling() {
        tabButton.addClass(TabButtonStyles.tabButton)
        selected.addClass(TabButtonStyles.selected)
        ic.addClass(TabButtonStyles.ic)
        root.addClass(TabButtonStyles.root)
        root.background = Background(BackgroundFill( Color.TRANSPARENT, null, null))
        importStylesheet(TabButtonStyles::class)
        reloadStylesheetsOnFocus()
    }
}
