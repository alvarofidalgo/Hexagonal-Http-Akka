package com.stratio.gosec.learning.model


/**
  * Encapsulate Values of determinate Column
  */
class ColumnValues (validValues:List[String]){

  /**
    * Retrieve valid values of column
    * @return
    */
  def getValidValues : List[String] = validValues

}
