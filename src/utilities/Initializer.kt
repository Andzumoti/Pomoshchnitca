package utilities

import java.awt.TrayIcon
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import javax.imageio.ImageIO

object Initializer {
	val setOfPlugins: MutableSet<Plugin>
	val trayIcon: TrayIcon
	init {
		var pluguinsDir: File
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
			pluguinsDir = File(getProperty("plugins"))
			iconPath = getProperty("icon")
		}
		setOfPlugins = pluguinsDir.listFiles().filter { it.path.contains(".properties") }.map { PluginLoader(it).load() }.toMutableSet()
		trayIcon = TrayIcon(ImageIO.read(javaClass.classLoader.getResource(iconPath))).apply {
			isImageAutoSize = true
		}
	}
}
