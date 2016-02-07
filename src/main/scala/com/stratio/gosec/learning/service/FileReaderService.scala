package com.stratio.gosec.learning.service

import akka.actor.ActorSystem

import akka.http.scaladsl.model.{MediaTypes, HttpEntity, StatusCodes, HttpResponse}
import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.stream.ActorMaterializer
import akka.util.ByteString


import com.stratio.gosec.learning.model.ColumnValues
import com.stratio.gosec.learning.service.parsers.ColumnValuesJsonParser._
import spray.json._


/**
  * Service to read File
  */
trait FileReaderService {
  implicit val system:ActorSystem
  implicit val materializer:ActorMaterializer

  val jsonResponse = ByteString(new ColumnValues(List("test1")).toJson.toString)


  val route =
    path("Correct") {
      get {
          complete {
           HttpResponse (status = StatusCodes.OK  ,entity=HttpEntity(MediaTypes.`application/json`,jsonResponse))
          }
        }
    }

}
