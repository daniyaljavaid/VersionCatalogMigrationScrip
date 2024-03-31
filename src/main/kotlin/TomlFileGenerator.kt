import java.io.File
import java.io.FileWriter

fun generateTomlFile(versions: MutableMap<String, String>, libraries: MutableList<String>) {
    val fileName = "libs.versions.toml"
    val content = buildString {
        append("[versions]")
        append("\n")
        versions.forEach {
            append("${it.key} = ${it.value}\n")
        }
        append("\n")
        append("[libraries]")
        append("\n")
        libraries.forEach {
            append("${it}\n")
        }
    }

    try {
        val file = File(fileName)
        val writer = FileWriter(file)
        writer.write(content)
        writer.close()
        println("File '$fileName' has been created with given content.")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}