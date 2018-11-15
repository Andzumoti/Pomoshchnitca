package utilities

import java.io.*
import java.util.*

class PluginLoader(private val file: File) {
	private lateinit var elements: MutableMap<String, String>// for debug
	private lateinit var plugin: Plugin
	
	fun load(): Plugin {
		Properties().apply {
			(FileInputStream(file) as InputStream).apply {
				load(this)
				close()
			}
			elements = stringPropertyNames().associateBy({ it }, { this.getProperty(it) }).toMutableMap()
			val thisClass = Class.forName(elements["className"])
			plugin = if (thisClass is Plugin) thisClass else nullPlugin()
		}
		return plugin
	}
	
	private fun nullPlugin(): Plugin {
		return object : Plugin {
			override val name = "nullName"
			override val className = "nullClassName"
			override val version = "0.0.0"
			override fun run() {}
		}
	}
}
