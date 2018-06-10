package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFacade, PyFunction}

class NeuralNetwork(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def relu: PyFunction = native
  def relu(features: Tensor): Tensor = native

  def softsign: PyFunction = native
  def softsign(features: Tensor): Tensor = native

  def tanh: PyFunction = native
  def tanh(features: Tensor): Tensor = native

  def sigmoid: PyFunction = native
  def sigmoid(features: Tensor): Tensor = native

  def l2_loss(t: Tensor): Tensor = native
}
