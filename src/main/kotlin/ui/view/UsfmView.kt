package ui.view

import com.sun.prism.paint.Color
import de.jensd.fx.glyphs.materialicons.MaterialIcon
import de.jensd.fx.glyphs.materialicons.MaterialIconView
import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.geometry.NodeOrientation
import javafx.geometry.Pos
import javafx.scene.control.ContentDisplay
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.Priority
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import tornadofx.Stylesheet.Companion.content
import ui.widget.TabButton
import java.util.*
import javax.swing.text.html.ImageView
import kotlin.jvm.javaClass

class UsfmView : View("Usfm Viewer") {

    val languageIcon = MaterialIconView(MaterialIcon.TRANSLATE, ".75cm")
    val bookIcon = MaterialIconView(MaterialIcon.BOOK, ".75cm")
    val chapterIcon = MaterialIconView(MaterialIcon.CHROME_READER_MODE, ".75cm")
    val settingsIcon = MaterialIconView(MaterialIcon.SETTINGS, ".75cm")

    var languageTab: TabButton
    var bookTab: TabButton
    var chapterTab: TabButton
    var settingsTab: TabButton

    init {
        languageIcon.fill = Paint.valueOf("#b3c1c1")
        bookIcon.fill = Paint.valueOf("#b3c1c1")
        chapterIcon.fill = Paint.valueOf("#b3c1c1")
        settingsIcon.fill = Paint.valueOf("#b3c1c1")

        languageTab = TabButton("Language", languageIcon)
        bookTab = TabButton("Book", bookIcon)
        chapterTab = TabButton("Chapter", chapterIcon)
        settingsTab = TabButton("Settings", settingsIcon)
    }

    override val root = borderpane {
        left = vbox {
            languageTab
        }
        center = vbox {
            textarea {
                text = "\n" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean suscipit, diam et accumsan venenatis, nulla dolor pellentesque quam, ac commodo est quam fermentum sem. Sed urna augue, porta eget diam in, mattis ornare magna. Donec elit est, dictum eu eleifend elementum, euismod et ipsum. Nullam nunc justo, tempus id sagittis eu, auctor a odio. Donec eros sapien, condimentum vel elementum ac, rutrum et odio. Suspendisse ullamcorper nisl et pellentesque convallis. Curabitur interdum a ex vel auctor. Nunc non magna in ante gravida semper.\n" +
                        "\n" +
                        "Aenean pellentesque libero diam, eu finibus justo elementum ac. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque nisl orci, iaculis vitae nunc ut, commodo tempor velit. Sed vitae vestibulum risus, et ornare ex. Maecenas finibus in lorem quis interdum. Proin eu erat at magna laoreet mollis. Ut lorem sapien, egestas at convallis vitae, placerat mattis augue. Nullam in viverra ipsum. Duis condimentum odio a tellus imperdiet, ac interdum tellus commodo. Vivamus ut egestas sem. Maecenas laoreet, arcu at laoreet posuere, ex velit mattis mi, ac euismod nulla justo eget magna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec convallis commodo ex sit amet pretium. Nulla facilisi.\n" +
                        "\n" +
                        "In hac habitasse platea dictumst. Nullam ac enim nec nulla eleifend porttitor vel vulputate leo. Quisque fringilla orci mi, et sagittis sapien imperdiet a. Ut laoreet, tellus vel efficitur congue, diam lorem lacinia mi, nec sollicitudin leo tortor nec metus. Donec dolor enim, tincidunt id turpis in, tempor fermentum ante. Nam eget mi nec tellus sollicitudin malesuada. Duis fermentum, dui consectetur gravida venenatis, ipsum metus luctus mauris, et egestas felis dui vitae enim. Praesent egestas justo id quam rhoncus dignissim. Integer in ex sapien.\n" +
                        "\n" +
                        "Phasellus odio dui, lacinia ac ornare tempor, dapibus vel lacus. Donec a rutrum magna. Fusce mattis dolor ipsum, at rutrum mauris maximus nec. Nullam scelerisque vehicula nunc, eget blandit dolor tempor vitae. Phasellus a pellentesque orci. Ut in maximus orci. Phasellus in quam auctor, consectetur tortor eu, placerat massa. Sed interdum justo vitae auctor rutrum. Sed condimentum dui dui, sit amet ultricies nisl lobortis sit amet. Aliquam erat volutpat. Nullam suscipit lacus ac ornare tincidunt.\n" +
                        "\n" +
                        "Maecenas at suscipit diam, et varius lacus. Nam pretium varius arcu ac sodales. Mauris a velit elementum, hendrerit dolor cursus, eleifend massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam a nulla hendrerit purus suscipit consectetur in sed arcu. Curabitur congue, lectus in semper hendrerit, elit enim lacinia justo, ac commodo ex ex sit amet dui. Proin lacinia, orci ut viverra iaculis, eros ipsum feugiat purus, non lobortis sem metus quis magna. Ut aliquam ac quam ac tristique. Phasellus in augue eu augue pulvinar dapibus. Phasellus vehicula mattis tincidunt. "
                vgrow = Priority.ALWAYS
                hgrow = Priority.ALWAYS
            }.style {
                fitToParentSize()
                wrapText = true
                textFill = Paint.valueOf("#BABABA")
                font = Font.font("monaco", FontWeight.BOLD, 9.0)
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#222324")))
                baseColor = javafx.scene.paint.Color.TRANSPARENT
            }
        }
        background = Background(BackgroundFill(Paint.valueOf("#244e66"), null, null))
        minHeight = 600.0
        minWidth = 600.0
    }
}


/*
override val root = borderpane {
        left = vbox {
            button(
                    "Language",
                    languageIcon
            ).style {
                contentDisplay = ContentDisplay.TOP
                alignment = Pos.CENTER
                fontSize = .75.em
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#002b36")))
                textFill = Paint.valueOf("#FFFFFF")
                minWidth = 15.mm
            }
            button(
                    "Book",
                    bookIcon
            ).style {
                contentDisplay = ContentDisplay.TOP;
                fontSize = .75.em
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#002b36")))
                textFill = Paint.valueOf("#FFFFFF")
                minWidth = 15.mm
            }
            button(
                    "Chapter",
                    chapterIcon
            ).style {
                contentDisplay = ContentDisplay.TOP;
                fontSize = .75.em
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#002b36")))
                textFill = Paint.valueOf("#FFFFFF")
                minWidth = 15.mm
            }
            button(
                    "Settings",
                    settingsIcon
            ).style {
                contentDisplay = ContentDisplay.TOP;
                fontSize = .75.em
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#002b36")))
                textFill = Paint.valueOf("#FFFFFF")
                minWidth = 15.mm
            }
            background = Background(BackgroundFill(Paint.valueOf("#244e66"), null, null))
            paddingAll = 6
            paddingTop = 12
            spacing = 8.0
        }
        center = vbox {
            textarea {
                text = "\n" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean suscipit, diam et accumsan venenatis, nulla dolor pellentesque quam, ac commodo est quam fermentum sem. Sed urna augue, porta eget diam in, mattis ornare magna. Donec elit est, dictum eu eleifend elementum, euismod et ipsum. Nullam nunc justo, tempus id sagittis eu, auctor a odio. Donec eros sapien, condimentum vel elementum ac, rutrum et odio. Suspendisse ullamcorper nisl et pellentesque convallis. Curabitur interdum a ex vel auctor. Nunc non magna in ante gravida semper.\n" +
                        "\n" +
                        "Aenean pellentesque libero diam, eu finibus justo elementum ac. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque nisl orci, iaculis vitae nunc ut, commodo tempor velit. Sed vitae vestibulum risus, et ornare ex. Maecenas finibus in lorem quis interdum. Proin eu erat at magna laoreet mollis. Ut lorem sapien, egestas at convallis vitae, placerat mattis augue. Nullam in viverra ipsum. Duis condimentum odio a tellus imperdiet, ac interdum tellus commodo. Vivamus ut egestas sem. Maecenas laoreet, arcu at laoreet posuere, ex velit mattis mi, ac euismod nulla justo eget magna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec convallis commodo ex sit amet pretium. Nulla facilisi.\n" +
                        "\n" +
                        "In hac habitasse platea dictumst. Nullam ac enim nec nulla eleifend porttitor vel vulputate leo. Quisque fringilla orci mi, et sagittis sapien imperdiet a. Ut laoreet, tellus vel efficitur congue, diam lorem lacinia mi, nec sollicitudin leo tortor nec metus. Donec dolor enim, tincidunt id turpis in, tempor fermentum ante. Nam eget mi nec tellus sollicitudin malesuada. Duis fermentum, dui consectetur gravida venenatis, ipsum metus luctus mauris, et egestas felis dui vitae enim. Praesent egestas justo id quam rhoncus dignissim. Integer in ex sapien.\n" +
                        "\n" +
                        "Phasellus odio dui, lacinia ac ornare tempor, dapibus vel lacus. Donec a rutrum magna. Fusce mattis dolor ipsum, at rutrum mauris maximus nec. Nullam scelerisque vehicula nunc, eget blandit dolor tempor vitae. Phasellus a pellentesque orci. Ut in maximus orci. Phasellus in quam auctor, consectetur tortor eu, placerat massa. Sed interdum justo vitae auctor rutrum. Sed condimentum dui dui, sit amet ultricies nisl lobortis sit amet. Aliquam erat volutpat. Nullam suscipit lacus ac ornare tincidunt.\n" +
                        "\n" +
                        "Maecenas at suscipit diam, et varius lacus. Nam pretium varius arcu ac sodales. Mauris a velit elementum, hendrerit dolor cursus, eleifend massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nullam a nulla hendrerit purus suscipit consectetur in sed arcu. Curabitur congue, lectus in semper hendrerit, elit enim lacinia justo, ac commodo ex ex sit amet dui. Proin lacinia, orci ut viverra iaculis, eros ipsum feugiat purus, non lobortis sem metus quis magna. Ut aliquam ac quam ac tristique. Phasellus in augue eu augue pulvinar dapibus. Phasellus vehicula mattis tincidunt. "
                vgrow = Priority.ALWAYS
                hgrow = Priority.ALWAYS
            }.style {
                fitToParentSize()
                wrapText = true
                textFill = Paint.valueOf("#BABABA")
                font = Font.font("monaco", FontWeight.BOLD, 9.0)
                backgroundColor = MultiValue<Paint>(arrayOf(Paint.valueOf("#222324")))
                baseColor = javafx.scene.paint.Color.TRANSPARENT
            }
        }
        background = Background(BackgroundFill(Paint.valueOf("#244e66"), null, null))
        minHeight = 600.0
        minWidth = 600.0
    }
 */