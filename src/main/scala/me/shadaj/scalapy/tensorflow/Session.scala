package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.numpy._
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFacade, ObjectWriter}

class PythonDict[K, V](o: py.Object)(implicit jep: Jep) extends py.Object(o.variableId)
object PythonDict {
  implicit def mapToPythonDict[K, V](map: Map[K, V])(implicit writer: ObjectWriter[Map[K, V]], jep: Jep): PythonDict[K, V] = {
    new PythonDict(py.global.dict(py.Object.from(map)))
  }
}

class Session(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def run(fetches: Operation): Unit = native

  def run(fetches: Variable): Seq[Double] = native

  def run(fetches: Tensor): Seq[NDArray[Double]] = native

  def run(fetches: Operation, feedDict: PythonDict[Tensor, py.Object]): Unit = native

  def run(fetches: Tensor, feedDict: PythonDict[Tensor, py.Object]): Seq[NDArray[Double]] = native

  def run(fetches: Seq[Tensor], feedDict: PythonDict[Tensor, py.Object]): Seq[Seq[NDArray[Double]]] = native
}
