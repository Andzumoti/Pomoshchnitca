package pomoshchnitca

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage

class Pomoshchnitca : Application() {
	override fun start(p0: Stage) {
		p0.scene = Scene(Label("Test"))
		p0.show()
	}
}

fun main(args: Array<String>) {
	Application.launch(Pomoshchnitca::class.java, *args)
}
