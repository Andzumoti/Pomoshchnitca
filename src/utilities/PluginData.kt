package utilities

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*

data class PluginData(var name: String, var author: String, var version: String, var hasManual: Boolean, var hasSetting: Boolean, var isActive: Boolean, var plugin: Plugin) {
	constructor(properties: Properties) : this("", "", "", false, false, false, NullPlugin) {
		properties.apply {
			name = getProperty("name")
			author = getProperty("author")
			version = getProperty("version")
			hasManual = (getProperty("hasManual") ?: "false").toBoolean()
			hasSetting = (getProperty("hasSetting") ?: "false").toBoolean()
			isActive = (getProperty("isActive") ?: "false").toBoolean()
			plugin = Class.forName(getProperty("className")).kotlin.objectInstance as Plugin
		}
	}
	
	constructor(file: File) : this(Properties().apply {
		(FileInputStream(file) as InputStream).apply {
			load(this)
			close()
		}
	})
}
