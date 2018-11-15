package pomoshchnitca

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage
import utilities.Initializer
import utilities.PluginData
import java.awt.TrayIcon
import java.io.File

class Pomoshchnitca : Application() {
	private lateinit var mapOfPluginData: MutableMap<File, PluginData>
	private lateinit var trayIcon: TrayIcon
	
	override fun init() {
		mapOfPluginData = Initializer.mapOfPluginData
		trayIcon = Initializer.trayIcon
	}
	
	override fun start(p0: Stage?) {
		mapOfPluginData.forEach { it.value.plugin.run() }
		p0?.scene = Scene(Label("Test"))
		p0?.show()
	}
}

fun main(args: Array<String>) {
	Application.launch(Pomoshchnitca::class.java, *args)
}
