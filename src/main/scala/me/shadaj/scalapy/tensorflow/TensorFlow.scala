package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFascade, PyFunction, |}

class TensorFlow(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def Variable(initialValue: Tensor): Variable = native

  def random_uniform(shape: Seq[py.NoneOr[Int]], min: Double, max: Double): Tensor = native

  def placeholder(`type`: String): Tensor = native

  def placeholder(`type`: String, shape: Seq[py.NoneOr[Int]]): Tensor = native

  def nn: NeuralNetwork = native
  def train: Training = native

  def matmul(a: Tensor, b: Tensor): Tensor = native

  def identity: PyFunction = native

  def identity(t: Tensor): Tensor = native

  def zeros(shape: Seq[Int]): Tensor = native

  def add_n(ts: Seq[Tensor]): Tensor = native

  def square(t: Tensor): Tensor = native

  def tanh(t: Tensor): Tensor = native

  def reduce_mean(t: Tensor): Tensor = native

  def gradients(ys: Tensor | Seq[Tensor], xs: Tensor | Seq[Tensor]): Seq[Tensor] = native

  def gradients(ys: Tensor, xs: Seq[Tensor], grad_ys: Tensor): Seq[Tensor] = native

  def initialize_all_variables(): Operation = native

  def global_variables_initializer(): Operation = native

  def Session(): Session = native

  def InteractiveSession(): Session = native

  def cond(c: Tensor, ifTrue: py.Object, ifFalse: py.Object): Tensor = native

  def contrib: Contrib = native
}
