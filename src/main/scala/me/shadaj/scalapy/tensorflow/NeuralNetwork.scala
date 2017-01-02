package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFascade, PyFunction}

class NeuralNetwork(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def relu: PyFunction = {
    dynamic.relu.as[PyFunction]
  }

  def relu(features: Tensor): Tensor = {
    dynamic.relu(features).as[Tensor]
  }

  def l2_loss(t: Tensor): Tensor = {
    dynamic.l2_loss(t).as[Tensor]
  }
}
