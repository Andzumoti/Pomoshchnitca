package pomoshchnitca

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage
import utilities.JSONValue

class Pomoshchnitca : Application() {
	lateinit var pluguins: List<JSONValue>
	
	override fun init() {
		
	}
	
	override fun start(p0: Stage?) {
		p0?.scene = Scene(Label("Test"))
		p0?.show()
	}
}

fun main(args: Array<String>) {
	Application.launch(Pomoshchnitca::class.java, *args)
}
