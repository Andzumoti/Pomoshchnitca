package utilities

import java.util.*

interface Runnable {
	fun run()
}

interface Configurable {
	fun configure()
}

interface Manual {
	fun manual()
}

open class Plugin: Runnable {
	open var myProperties = Properties()
	override fun run() {
	}
	open fun getProperty(string: String) = myProperties.getProperty(string)
	open fun load(properties: Properties) {
		myProperties = properties
	}
}
object NullPlugin : Plugin() {
	override fun run() {}
}
