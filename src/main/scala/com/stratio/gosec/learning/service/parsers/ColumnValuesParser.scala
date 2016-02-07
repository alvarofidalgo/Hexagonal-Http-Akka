package com.stratio.gosec.learning.service.parsers

import com.stratio.gosec.learning.model.ColumnValues
import spray.json._

/**
 * Class that is called by toJson spray method
 * @param values
 */
case class ColumnValuesParser (values :ColumnValues )

/**
 * Object that parser do
 */
object ColumnValuesJsonParser extends DefaultJsonProtocol{

  /**
   * Transform ColumnValues to Json Object
   */
  implicit object ColumnValuesFormat extends RootJsonFormat[ColumnValues] {
    def write(columnValues: ColumnValues) = JsObject(
      "ColumnValues" -> JsObject(
          "validValues" -> JsArray(columnValues
                                       .getValidValues
                                           .map(value=>JsString(value))
                                              .toVector)
          )
    )

    /**
     * Transform json Object to ColumnValues
     * @param json Json to transform
     * @return ColumnValues parsered
     */
    //TODO : IMPLEMENT THOS METHOD
    override def read(json: JsValue): ColumnValues = {

       new ColumnValues(List())
    }
  }
}
