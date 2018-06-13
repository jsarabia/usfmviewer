package ui.view

import com.jfoenix.controls.JFXDrawer
import de.jensd.fx.glyphs.materialicons.MaterialIcon
import de.jensd.fx.glyphs.materialicons.MaterialIconView
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import tornadofx.*
import ui.view.styles.UsfmViewStyles

class UsfmView : View("Usfm Viewer") {

    override val root = BorderPane()

    val tabPane = VBox()
    val textArea = TextArea()
    val drawer = JFXDrawer()
    val languageDrawer = LanguageDrawer()

    var languageTab: TabButton
    var bookTab: TabButton
    var chapterTab: TabButton
    var settingsTab: TabButton

    val languageIcon = MaterialIconView(MaterialIcon.TRANSLATE, ".75cm")
    val bookIcon = MaterialIconView(MaterialIcon.BOOK, ".75cm")
    val chapterIcon = MaterialIconView(MaterialIcon.CHROME_READER_MODE, ".75cm")
    val settingsIcon = MaterialIconView(MaterialIcon.SETTINGS, ".75cm")

    init {
        languageTab = TabButton("Language", languageIcon)
        bookTab = TabButton("Book", bookIcon)
        chapterTab = TabButton("Chapter", chapterIcon)
        settingsTab = TabButton("Settings", settingsIcon)

        languageTab.tabButton.setOnMouseClicked {
            println("language clicked")
            if (drawer.isOpened) {
                drawer.close()
            } else {
                //setting toFront in onDrawerOpening causes janky animations
                drawer.toFront()
                drawer.open()
            }
            languageTab.selected.isVisible = !languageTab.selected.isVisible

        }
        bookTab.tabButton.setOnMouseClicked {
            println("book clicked")
        }
        chapterTab.tabButton.setOnMouseClicked { println("chapter clicked") }
        settingsTab.tabButton.setOnMouseClicked { println("settings clicked") }

        drawer.setOnDrawerClosed {
            drawer.toBack()
        }

        with(root) {
            left = tabPane.apply {
                this += languageTab
                this += bookTab
                this += chapterTab
                this += settingsTab
            }

            center = stackpane {
                this += drawer.apply {
                    direction = JFXDrawer.DrawerDirection.RIGHT
                    setSidePane(languageDrawer)
                    defaultDrawerSize = 400.0
                }
                this += textArea
            }
        }

        addStyling()

        initText()
    }

    private inline fun addStyling() {
        tabPane.addClass(UsfmViewStyles.tabPane)
        textArea.addClass(UsfmViewStyles.textArea)
        drawer.addClass(UsfmViewStyles.drawer)
        importStylesheet(UsfmViewStyles::class)
        reloadStylesheetsOnFocus()
    }

    private inline fun initText() {
        textArea.text = "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean suscipit, diam et accumsan venenatis, nulla dolor pellentesque quam, ac commodo est quam fermentum sem. Sed urna augue, porta eget diam in, mattis ornare magna. Donec elit est, dictum eu eleifend elementum, euismod et ipsum. Nullam nunc justo, tempus id sagittis eu, auctor a odio. Donec eros sapien, condimentum vel elementum ac, rutrum et odio. Suspendisse ullamcorper nisl et pellentesque convallis. Curabitur interdum a ex vel auctor. Nunc non magna in ante gravida semper.\n" +
                "\n" +
                "Aenean pellentesque libero diam, eu finibus justo elementum ac. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque nisl orci, iaculis vitae nunc ut, commodo tempor velit. Sed vitae vestibulum risus, et ornare ex. Maecenas finibus in lorem quis interdum. Proin eu erat at magna laoreet mollis. Ut lorem sapien, egestas at convallis vitae, placerat mattis augue. Nullam in viverra ipsum. Duis condimentum odio a tellus imperdiet, ac interdum tellus commodo. Vivamus ut egestas sem. Maecenas laoreet, arcu at laoreet posuere, ex velit mattis mi, ac euismod nulla justo eget magna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec convallis commodo ex sit amet pretium. Nulla facilisi.\n" +
                "\n" +
                "In hac habitasse platea dictumst. Nullam ac enim nec nulla eleifend porttitor vel vulputate leo. Quisque fringilla orci mi, et sagittis sapien imperdiet a. Ut laoreet, tellus vel efficitur congue, diam lorem lacinia mi, nec sollicitudin leo tortor nec metus. Donec dolor enim, tincidunt id turpis in, tempor fermentum ante. Nam eget mi nec tellus sollicitudin malesuada. Duis fermentum, dui consectetur gravida venenatis, ipsum metus luctus mauris, et egestas felis dui vitae enim. Praesent egestas justo id quam rhoncus dignissim. Integer in ex sapien.\n" +
                "\n" +
                "Phasellus odio dui, lacinia ac ornare tempor, dapibus vel lacus. Donec a rutrum magna. Fusce mattis dolor ipsum, at rutrum mauris maximus nec. Nullam scelerisque vehicula nunc, eget blandit dolor tempor vitae. Phasellus a pellentesque orci. Ut in maximus orci. Phasellus in quam auctor, consectetur tortor eu, placerat massa. Sed interdum justo vitae auctor rutrum. Sed condimentum dui dui, sit amet ultricies nisl lobortis sit amet. Aliquam erat volutpat. Nullam suscipit lacus ac ornare tincidunt.\n" +
                "\n" +
                "Maecenas at suscipit diam, et varius lacus. Nam pretium varius arcu ac sodales. Mauris a velit elementum, hendrerit dolor cursus, eleifend massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam a nulla hendrerit purus suscipit consectetur in sed arcu. Curabitur congue, lectus in semper hendrerit, elit enim lacinia justo, ac commodo ex ex sit amet dui. Proin lacinia, orci ut viverra iaculis, eros ipsum feugiat purus, non lobortis sem metus quis magna. Ut aliquam ac quam ac tristique. Phasellus in augue eu augue pulvinar dapibus. Phasellus vehicula mattis tincidunt. "
    }
}


/*

package ui.view

import com.jfoenix.controls.JFXDrawer
import de.jensd.fx.glyphs.materialicons.MaterialIcon
import de.jensd.fx.glyphs.materialicons.MaterialIconView
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import tornadofx.*
import ui.view.styles.UsfmViewStyles

class UsfmView : View("Usfm Viewer") {

    override val root: BorderPane by fxml()

    val tabPane: VBox by fxid()
    val textArea: TextArea by fxid()
    val drawer: JFXDrawer by fxid()
    val languageDrawer = LanguageDrawer()

    var languageTab: TabButton
    var bookTab: TabButton
    var chapterTab: TabButton
    var settingsTab: TabButton

    val languageIcon = MaterialIconView(MaterialIcon.TRANSLATE, ".75cm")
    val bookIcon = MaterialIconView(MaterialIcon.BOOK, ".75cm")
    val chapterIcon = MaterialIconView(MaterialIcon.CHROME_READER_MODE, ".75cm")
    val settingsIcon = MaterialIconView(MaterialIcon.SETTINGS, ".75cm")

    init {
        languageTab = TabButton("Language", languageIcon)
        bookTab = TabButton("Book", bookIcon)
        chapterTab = TabButton("Chapter", chapterIcon)
        settingsTab = TabButton("Settings", settingsIcon)
        drawer.close()
        drawer.setSidePane(languageDrawer)

        drawer.isResizeContent = true
        drawer.fitToParentHeight()

        languageTab.tabButton.setOnMouseClicked {
            println("language clicked")
            if (languageTab.selected.isVisible) {
                drawer.close()
            } else {
                drawer.open()
            }
            languageTab.selected.isVisible = !languageTab.selected.isVisible

        }
        bookTab.tabButton.setOnMouseClicked {
            println("book clicked")
        }
        chapterTab.tabButton.setOnMouseClicked { println("chapter clicked") }
        settingsTab.tabButton.setOnMouseClicked { println("settings clicked") }

        tabPane += languageTab
        tabPane += bookTab
        tabPane += chapterTab
        tabPane += settingsTab

        addStyling()

        initText()
    }

    private inline fun addStyling() {
        tabPane.addClass(UsfmViewStyles.tabPane)
        textArea.addClass(UsfmViewStyles.textArea)
        importStylesheet(UsfmViewStyles::class)
        reloadStylesheetsOnFocus()
    }

    private inline fun initText() {
        textArea.text = "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean suscipit, diam et accumsan venenatis, nulla dolor pellentesque quam, ac commodo est quam fermentum sem. Sed urna augue, porta eget diam in, mattis ornare magna. Donec elit est, dictum eu eleifend elementum, euismod et ipsum. Nullam nunc justo, tempus id sagittis eu, auctor a odio. Donec eros sapien, condimentum vel elementum ac, rutrum et odio. Suspendisse ullamcorper nisl et pellentesque convallis. Curabitur interdum a ex vel auctor. Nunc non magna in ante gravida semper.\n" +
                "\n" +
                "Aenean pellentesque libero diam, eu finibus justo elementum ac. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque nisl orci, iaculis vitae nunc ut, commodo tempor velit. Sed vitae vestibulum risus, et ornare ex. Maecenas finibus in lorem quis interdum. Proin eu erat at magna laoreet mollis. Ut lorem sapien, egestas at convallis vitae, placerat mattis augue. Nullam in viverra ipsum. Duis condimentum odio a tellus imperdiet, ac interdum tellus commodo. Vivamus ut egestas sem. Maecenas laoreet, arcu at laoreet posuere, ex velit mattis mi, ac euismod nulla justo eget magna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec convallis commodo ex sit amet pretium. Nulla facilisi.\n" +
                "\n" +
                "In hac habitasse platea dictumst. Nullam ac enim nec nulla eleifend porttitor vel vulputate leo. Quisque fringilla orci mi, et sagittis sapien imperdiet a. Ut laoreet, tellus vel efficitur congue, diam lorem lacinia mi, nec sollicitudin leo tortor nec metus. Donec dolor enim, tincidunt id turpis in, tempor fermentum ante. Nam eget mi nec tellus sollicitudin malesuada. Duis fermentum, dui consectetur gravida venenatis, ipsum metus luctus mauris, et egestas felis dui vitae enim. Praesent egestas justo id quam rhoncus dignissim. Integer in ex sapien.\n" +
                "\n" +
                "Phasellus odio dui, lacinia ac ornare tempor, dapibus vel lacus. Donec a rutrum magna. Fusce mattis dolor ipsum, at rutrum mauris maximus nec. Nullam scelerisque vehicula nunc, eget blandit dolor tempor vitae. Phasellus a pellentesque orci. Ut in maximus orci. Phasellus in quam auctor, consectetur tortor eu, placerat massa. Sed interdum justo vitae auctor rutrum. Sed condimentum dui dui, sit amet ultricies nisl lobortis sit amet. Aliquam erat volutpat. Nullam suscipit lacus ac ornare tincidunt.\n" +
                "\n" +
                "Maecenas at suscipit diam, et varius lacus. Nam pretium varius arcu ac sodales. Mauris a velit elementum, hendrerit dolor cursus, eleifend massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam a nulla hendrerit purus suscipit consectetur in sed arcu. Curabitur congue, lectus in semper hendrerit, elit enim lacinia justo, ac commodo ex ex sit amet dui. Proin lacinia, orci ut viverra iaculis, eros ipsum feugiat purus, non lobortis sem metus quis magna. Ut aliquam ac quam ac tristique. Phasellus in augue eu augue pulvinar dapibus. Phasellus vehicula mattis tincidunt. "
    }
}

 */