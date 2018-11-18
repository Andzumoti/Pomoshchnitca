package pomoshchnitca

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.stage.Stage
import utilities.Initializer
import utilities.PluginData
import java.util.*

class Pomoshchnitca : Application() {
	private lateinit var mapOfPluginData: MutableMap<Properties, PluginData>
	private lateinit var iconPath: String
	companion object {
		lateinit var primaryStage: Stage
	}
	
	override fun init() {
		mapOfPluginData = Initializer.mapOfPluginData
		iconPath = Initializer.iconPath
	}
	
	override fun start(p0: Stage) {
		primaryStage = p0.apply {
			scene = Scene(Label("Test"))
			icons.add(Image(iconPath))
		}
		mapOfPluginData.filter { it.value.isActive }.forEach { it.value.plugin.apply { it.value.plugin.load(it.key) }.run() }
		if (!primaryStage.isShowing) primaryStage.show()
	}
}

fun main(args: Array<String>) {
	Application.launch(Pomoshchnitca::class.java, *args)
}
