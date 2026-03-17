fun main(args: Array<String>)
{
    val targetUrl = "https://jsonplaceholder.typicode.com/todos/1"
    val crawler = Crawler(targetUrl)
    val myParser = JsonParser()

    val content = crawler.getResource()

    if (content != null)
    {
        crawler.processContent(content, myParser)
    }
    else
    {
        println("probleme la preluarea continutului")
    }
}