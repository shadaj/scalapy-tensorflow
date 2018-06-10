package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class ExponentialMovingAverage(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def apply(vars: Seq[Tensor]): Operation = native

  def average(v: Variable): Variable = native
}
