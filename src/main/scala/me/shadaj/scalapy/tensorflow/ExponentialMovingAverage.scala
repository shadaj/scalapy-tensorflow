package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class ExponentialMovingAverage(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def apply(vars: Seq[Tensor]): Operation = {
    dynamic.apply(vars).as[Operation]
  }

  def average(v: Variable): Variable = {
    dynamic.average(v).as[Variable]
  }
}
