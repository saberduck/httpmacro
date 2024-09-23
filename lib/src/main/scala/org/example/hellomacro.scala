package org.example

import java.net.http.*
import java.net.URI
import java.net.http.HttpResponse.BodyHandlers

import scala.quoted.* // imports Quotes, Expr

def inspectCode(x: Expr[Any])(using Quotes): Expr[Any] =
  println(System.getProperty("java.version"))
  ModuleLayer.boot().modules().stream()
    .map(m => m.getName)
    .forEach(n => println(n))
  Class.forName("java.net.http.HttpClient")
  x

inline def inspect(inline x: Any): Any = ${ inspectCode('x) }

