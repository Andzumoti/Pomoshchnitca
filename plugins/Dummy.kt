import utilities.Plugin

object Dummy : Plugin {
	override val name: String
		get() = "Dummy"
	override val className: String
		get() = "Dummy"
	override val version: String
		get() = "Dummy"
	override fun run() {}
}
