import java.net.URI
import java.net.http.*
import java.net.http.HttpResponse.BodyHandlers

@main def hello() =
  inspect("Hello, World!")
  val client = HttpClient.newHttpClient
  val request = HttpRequest.newBuilder.uri(URI.create("http://google.com/")).build
  val res = client.send(request, BodyHandlers.ofString)
  println(res.body())
  println("done")


 
