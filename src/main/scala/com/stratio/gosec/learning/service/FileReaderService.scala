package com.stratio.gosec.learning.service

import akka.actor.ActorSystem

import akka.http.scaladsl.model.{MediaTypes, HttpEntity, StatusCodes, HttpResponse}
import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.stream.ActorMaterializer
import akka.util.ByteString

/**
  * Service to
  */
trait FileReaderService {
  implicit val system:ActorSystem
  implicit val materializer:ActorMaterializer
  val jsonRequest =
    ByteString(
      s"""
         |{
         |    "validValues":["test1","test2"]
         |}
        """.stripMargin)

  val route =
    path("Correct") {
      get {
          complete {
           HttpResponse (status = StatusCodes.OK  ,entity=HttpEntity(MediaTypes.`application/json`, jsonRequest))

          }
        }
    }

}
