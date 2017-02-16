package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFascade, PyFunction}

class NeuralNetwork(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def relu: PyFunction = native

  def relu(features: Tensor): Tensor = native

  def l2_loss(t: Tensor): Tensor = native
}
