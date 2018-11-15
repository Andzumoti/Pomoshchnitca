package pomoshchnitca

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage
import utilities.Initializer
import utilities.Plugin
import java.awt.TrayIcon

class Pomoshchnitca : Application() {
	private lateinit var setOfPlugins: MutableSet<Plugin>
	private lateinit var trayIcon: TrayIcon
	
	override fun init() {
		setOfPlugins = Initializer.setOfPlugins
		trayIcon = Initializer.trayIcon
	}
	
	override fun start(p0: Stage?) {
		setOfPlugins.forEach { it.run() }
		p0?.scene = Scene(Label("Test"))
		p0?.show()
	}
}

fun main(args: Array<String>) {
	Application.launch(Pomoshchnitca::class.java, *args)
}
