import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.StageStyle.*
import pomoshchnitca.Pomoshchnitca
import utilities.Configurable
import utilities.Manual
import utilities.Plugin
import java.io.File
import java.io.FileInputStream
import java.util.*

object CharacterView : Plugin(), Configurable, Manual {
	private lateinit var imageView: ImageView
	lateinit var characterDir: String
	lateinit var default: String
	lateinit var smile: String
	lateinit var wink: String
	var x: Double = 0.0
	var y: Double = 0.0
	var width: Double = 750.0
	private val dir = System.getProperty("user.dir")!!
	
	override fun load(properties: Properties) {
		super.load(properties)
		characterDir = getProperty("characterDir")
		default = "$characterDir/${getProperty("default")}"
		smile = "$characterDir/${getProperty("smile")}"
		wink = "$characterDir/${getProperty("wink")}"
		x = (getProperty("x") ?: "0.0").toDouble()
		y = (getProperty("y") ?: "0.0").toDouble()
		width = (getProperty("width") ?: "750.0").toDouble()
	}
	
	override fun run() {
		
		val ownerStage = Pomoshchnitca.primaryStage.apply {
			initStyle(UTILITY)
			x = -1000.0
			y = -1000.0
			opacity = 0.0
			scene.fill = null
			show()
		}
		Stage().apply {
			isAlwaysOnTop = true
			initOwner(ownerStage)
			scene = if (characterDir == "null") Scene(Label("Character is not initialized")) else Scene(AnchorPane().apply {
				ImageView(Image(FileInputStream(File("$dir/$default")))).apply {
					imageView = this
					fitWidth = width
					isPreserveRatio = true
					isSmooth = true
					isCache = true
				}
				children.add(imageView)
			})
			scene.fill = null
			this.initStyle(TRANSPARENT)
			x = this@CharacterView.x
			y = this@CharacterView.y
		}.show()
	}
	
	override fun configure() {
	}
	
	override fun manual() {
	
	}
}
