import java.net.URI
import java.net.http.*
import java.net.http.HttpResponse.BodyHandlers
import scala.quoted.* // imports Quotes, Expr

def inspectCode(x: Expr[Any])(using Quotes): Expr[Any] =
  val client = HttpClient.newHttpClient
  val request = HttpRequest.newBuilder.uri(URI.create("http://google.com/")).build
  val res = client.send(request, BodyHandlers.ofString)
  println(res.body())
  println(x.show)
  x

inline def inspect(inline x: Any): Any = ${ inspectCode('x) }

