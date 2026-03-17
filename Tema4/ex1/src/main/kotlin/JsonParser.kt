import org.jsoup.Jsoup

class JsonParser : Parser {
    override fun parse(url: String, content: String): String
    {
        val doc = Jsoup.parse(content)
        val titlu = doc.title()
        val caractere = content.length

        return """
        {
            "sursa": "$url",
            "detalii": {
                "titlu_pagina": "$titlu",
                "total_caractere": $caractere
            },
        }
        """.trimIndent()
    }
}