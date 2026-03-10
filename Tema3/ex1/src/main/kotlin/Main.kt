import org.jsoup.Jsoup
import org.jsoup.parser.Parser

// 1. Definim ADT-ul pentru un element individual (item)
data class RSSItem(
    val title: String,
    val link: String,
    val description: String,
    val pubDate: String
)

// 2. Definim ADT-ul pentru intregul feed RSS, care contine lista de item-uri
data class RSSFeed(
    var title: String = "",
    var link: String = "",
    var description: String = "",
    val items: MutableList<RSSItem> = mutableListOf()
)

fun main() {
    //Link-ul RSS-ului
    val url = "http://rss.cnn.com/rss/edition.rss"

    val doc = Jsoup.connect(url)
        .parser(Parser.xmlParser())
        .get()

    val feed = RSSFeed()

    feed.title = doc.selectFirst("channel > title")?.text() ?: ""
    feed.link = doc.selectFirst("channel > link")?.text() ?: ""
    feed.description = doc.selectFirst("channel > description")?.text() ?: ""

    val items = doc.select("item")

    for (item in items) {

        val title = item.selectFirst("title")?.text() ?: ""
        val link = item.selectFirst("link")?.text() ?: ""
        val description = item.selectFirst("description")?.text() ?: ""
        val pubDate = item.selectFirst("pubDate")?.text() ?: ""

        val rssItem = RSSItem(title, link, description, pubDate)

        feed.items.add(rssItem)
    }

    println("Feed: ${feed.title}\n")

    for (item in feed.items) {
        println("Title: ${item.title}")
        println("Link: ${item.link}")
        println("Date: ${item.pubDate}")
        println("Description: ${item.description}")
        println("-------------")
    }
}