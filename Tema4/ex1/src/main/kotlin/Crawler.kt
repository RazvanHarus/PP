import org.jsoup.Jsoup

class Crawler(private var url: String) {
    fun getResource(): String
    {
        return Jsoup.connect(url).ignoreContentType(true).execute().body()
    }

    fun processContent(content: String, parser: Parser)
    {
        val jsonRezultat = parser.parse(url, content)
        println(jsonRezultat)
        java.io.File("output.json").writeText(jsonRezultat)
    }
}