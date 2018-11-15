package utilities

interface Plugin {
	val name: String
	val className: String
	val version: String
	fun run()
}
