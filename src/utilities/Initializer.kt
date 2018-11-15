package utilities

import java.awt.TrayIcon
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import javax.imageio.ImageIO

object Initializer {
	val mapOfPluginData: MutableMap<File,PluginData>
	val trayIcon: TrayIcon
	init {
		var pluginsDir: File
		var iconPath: String
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
		mapOfPluginData = pluginsDir.listFiles().filter { it.path.contains(".properties") }.associateBy({it}, {PluginData(it)}).toMutableMap()
		trayIcon = TrayIcon(ImageIO.read(javaClass.classLoader.getResource(iconPath))).apply {
			isImageAutoSize = true
		}
	}
}
