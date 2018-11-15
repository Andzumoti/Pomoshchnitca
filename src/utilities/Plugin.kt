package utilities

interface Plugin {
	fun run()
}

object NullPlugin : Plugin {
	override fun run() {}
}
