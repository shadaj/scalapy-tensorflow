package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.numpy._
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class Session(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def run(fetches: Operation): Unit = {
    dynamic.run(fetches)
  }

  def run(fetches: Variable): Seq[Double] = {
    dynamic.run(fetches).as[Seq[Double]]
  }

  def run(fetches: Tensor): Seq[NDArray[Double]] = {
    dynamic.run(fetches).as[Seq[NDArray[Double]]]
  }

  def run(fetches: Operation, feedDict: Map[Tensor, py.Object]): Unit = {
    dynamic.run(fetches, feedDict)
  }

  def run(fetches: Tensor, feedDict: Map[Tensor, py.Object]): Seq[NDArray[Double]] = {
    dynamic.run(fetches, feedDict).as[Seq[NDArray[Double]]]
  }

  def run(fetches: Seq[Tensor], feedDict: Map[Tensor, py.Object]): Seq[Seq[NDArray[Double]]] = {
    dynamic.run(fetches, feedDict).as[Seq[Seq[NDArray[Double]]]]
  }
}
