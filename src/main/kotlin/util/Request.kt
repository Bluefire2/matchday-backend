package util

import java.net.URL
import java.util.concurrent.Callable
import java.io.InputStream

class Request(private val url: URL) : Callable<Response> {
    @Throws(Exception::class)
    override fun call(): Response {
        return Response(url.openStream())
    }
}

class Response(val body: InputStream)