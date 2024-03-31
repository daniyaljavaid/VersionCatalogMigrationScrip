import java.io.File
import java.io.FileWriter

fun generateGradleFile(gradleDependencies: MutableList<String>) {
    val fileName = "_build.gradle.kts"
    val content = buildString {
        append("dependencies {")
        append("\n")
        gradleDependencies.forEach {
            append("\t${it}\n")
        }
        append("}")

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