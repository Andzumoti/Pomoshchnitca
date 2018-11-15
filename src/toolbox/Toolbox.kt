package toolbox

import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.Stage
import utilities.Initializer
import utilities.Plugin
import java.util.*

class Toolbox : Application() {
	private lateinit var setOfPlugins: MutableSet<Plugin>
	private lateinit var setOfPluginProperties: MutableSet<Properties>
	
	override fun init() {
		setOfPlugins = Initializer.setOfPlugins
		
	}
	
	override fun start(p0: Stage) {
		with(p0) {
			title = "Pomoshchnitca(Помощница) - Toolbox"
			isResizable = false
			scene = Scene(FXMLLoader.load(javaClass.classLoader.getResource("resources/fxml/Toolbox.fxml")))
			show()
			setOnCloseRequest {
				Alert(Alert.AlertType.CONFIRMATION).apply {
					title = "Notification"
					headerText = null
					contentText = "Are you sure to close without saving"
					showAndWait().apply {
						if (this.get() == ButtonType.OK) System.exit(0) else it.consume()
					}
				}
			}
		}
	}
	@FXML private fun closeWithSave() {
		close()
	}
	
	@FXML private fun close() {
		System.exit(0)
	}
	
	@FXML private fun applySession() {
	}
}

fun main(args: Array<String>) {
	Application.launch(Toolbox::class.java, *args)
}
