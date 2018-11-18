import utilities.Plugin
import utilities.Runnable

object Dummy : Plugin() {
	override fun run() {
		println("Dummy is loaded")
	}
}
