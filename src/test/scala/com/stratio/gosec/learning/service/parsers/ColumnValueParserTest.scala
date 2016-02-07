package com.stratio.gosec.learning.service.parsers

import com.stratio.gosec.learning.model.ColumnValues
import org.scalatest.{WordSpec, ShouldMatchers}

import com.stratio.gosec.learning.service.parsers.ColumnValuesJsonParser._
import spray.json._

/**
 * Test ColumnValueParser
 */
class ColumnValueParserTest extends WordSpec with ShouldMatchers{



  "Result ot parser " should {

     " be json Object with one item in list "  in {
           val column = new ColumnValues(List("test1"))
           val json  =column.toJson
           json.toString shouldBe   s"""{"ColumnValues":{"validValues":["test1"]}}"""

     }

    " be json Object with two item in list" in {

      val column = new ColumnValues(List("test1","test2"))
      val json  =column.toJson
      json.toString shouldBe   s"""{"ColumnValues":{"validValues":["test1","test2"]}}"""
    }


   }




}
