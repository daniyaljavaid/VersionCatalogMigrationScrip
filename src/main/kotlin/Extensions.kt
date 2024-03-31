

fun String.removeSurroundingBraces() = removeSurrounding("(", ")")
fun String.removeSurroundingQuotes() = removeSurrounding("\"", "\"")

fun String.removePlatformPrefixIfExists() =
    if (startsWith("platform")) removePlatformPrefix()
    else
        this

fun String.removeImplementationPrefix() =
    replace(".*implementation".toRegex(RegexOption.IGNORE_CASE), "")
        .removeSurroundingBraces()
        .removeSurroundingQuotes()

fun String.removePlatformPrefix() =
    replace(".*platform".toRegex(RegexOption.IGNORE_CASE), "")
        .removeSurroundingBraces()
        .removeSurroundingQuotes()


