package com.stratio.gosec.learning.service


import akka.http.scaladsl.model.{HttpEntity, HttpRequest,HttpMethods,MediaTypes,StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{ShouldMatchers, WordSpec}

/**
  * Test to Service that read files
  */
class FileReaderServiceTest extends WordSpec with ShouldMatchers with ScalatestRouteTest with FileReaderService{


  "When client call getAll " should {

      "retrieve all correct value of column name files and exists values" in {

        val jsonRequest =

            s"""
               |{
               |    "validValues":["test1","test2"]
               |}
        """.stripMargin

        val request = HttpRequest(
                                       HttpMethods.GET,
                                       uri = "/Correct",
                                       entity = HttpEntity(MediaTypes.`application/json`, jsonRequest)
                                      )

        request ~> route ~> check {
          status shouldEqual StatusCodes.OK
          entityAs[HttpEntity].contentType.toString() shouldBe  MediaTypes.`application/json`.toString()
          responseAs[String].toString() shouldBe jsonRequest.toString()
        }
      }
  }
}
