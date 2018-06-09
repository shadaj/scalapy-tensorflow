package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.numpy._
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class Session(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def run(fetches: Operation): Unit = native

  def run(fetches: Variable): Seq[Double] = native

  def run(fetches: Tensor): Seq[NDArray[Double]] = native

  def run(fetches: Operation, feedDict: Map[Tensor, py.Object]): Unit = native

  def run(fetches: Tensor, feedDict: Map[Tensor, py.Object]): Seq[NDArray[Double]] = native

  def run(fetches: Seq[Tensor], feedDict: Map[Tensor, py.Object]): Seq[Seq[NDArray[Double]]] = native
}
