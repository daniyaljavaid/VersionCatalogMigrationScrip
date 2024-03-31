fun main() {
    val inputString = """
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    """

    inputString.split("\n")
        .filter { it.trim().isNotEmpty() }
        .forEach {
            println("==========================")

            val filteredInput = it.removeImplementationPrefix().removePlatformPrefixIfExists()

            val arr = filteredInput.split(":")

            val group = arr[0]
            val name = arr[1]

            var versionString = ""

            if (arr.size == 3)
                versionString = ", version.ref = \"${arr[2]}\""

            val tomlOutput = "$name = { group = \"${group}\", name = \"${name}\"${versionString}}"

            val startingIndex = it.trim().indexOf("\"")
            val endingIndex = it.trim().indexOf("\"", startingIndex + 1)
            val gradleOutput = it.trim().replaceRange(startingIndex, endingIndex + 1, "libs.${name.replace("-", ".")}")

            println(it.trim())
            println(filteredInput)
            println(tomlOutput)
            println(gradleOutput)
        }

}