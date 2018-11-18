package utilities

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*

object Initializer {
	val mapOfPluginData: MutableMap<Properties, PluginData>
	val iconPath: String
	
	init {
		var pluginsDir: File
		Properties().apply {
			try {
				(FileInputStream("pomoshchnitca.properties") as InputStream).apply {
					load(this)
					close()
				}
			} catch (e: Exception) {
				e.printStackTrace()
				System.exit(0)
			}
			pluginsDir = File(getProperty("plugins"))
			iconPath = getProperty("icon")
		}
		mapOfPluginData = pluginsDir.listFiles().filter { it.path.contains(".properties") }.associateBy({
			Properties().apply {
				FileInputStream(it).apply { load(this) }.close()
			}
		}, { PluginData(it) }).toMutableMap()
	}
}

