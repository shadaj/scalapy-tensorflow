package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFascade, PyFunction, |}

class TensorFlow(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def Variable(initialValue: Tensor): Variable = {
    dynamic.Variable(initialValue).as[Variable]
  }

  def random_uniform(shape: Seq[py.NoneOr[Int]], min: Double, max: Double): Tensor = {
    dynamic.random_uniform(shape, min, max).as[Tensor]
  }

  def placeholder(`type`: String): Tensor = {
    dynamic.placeholder(`type`).as[Tensor]
  }

  def placeholder(`type`: String, shape: Seq[py.NoneOr[Int]]): Tensor = {
    dynamic.placeholder(`type`, shape).as[Tensor]
  }

  def nn: NeuralNetwork = dynamic.nn.as[NeuralNetwork]
  def train: Training = dynamic.train.as[Training]

  def matmul(a: Tensor, b: Tensor): Tensor = {
    dynamic.matmul(a, b).as[Tensor]
  }

  def identity: PyFunction = {
    dynamic.identity.as[PyFunction]
  }

  def identity(t: Tensor): Tensor = {
    dynamic.identity(t).as[Tensor]
  }

  def zeros(shape: Seq[Int]): Tensor = {
    dynamic.zeros(shape).as[Tensor]
  }

  def add_n(ts: Seq[Tensor]): Tensor = {
    dynamic.add_n(ts).as[Tensor]
  }

  def square(t: Tensor): Tensor = {
    dynamic.square(t).as[Tensor]
  }

  def tanh(t: Tensor): Tensor = {
    dynamic.tanh(t).as[Tensor]
  }

  def reduce_mean(t: Tensor): Tensor = {
    dynamic.reduce_mean(t).as[Tensor]
  }

  def gradients(ys: Tensor | Seq[Tensor], xs: Tensor | Seq[Tensor]): Seq[Tensor] = {
    dynamic.gradients(ys, xs).as[Seq[Tensor]]
  }

  def gradients(ys: Tensor, xs: Seq[Tensor], grad_ys: Tensor): Seq[Tensor] = {
    dynamic.gradients(ys, xs, grad_ys).as[Seq[Tensor]]
  }

  def initialize_all_variables(): Operation = {
    dynamic.initialize_all_variables().as[Operation]
  }

  def global_variables_initializer(): Operation = {
    dynamic.global_variables_initializer().as[Operation]
  }

  def Session(): Session = {
    dynamic.Session().as[Session]
  }

  def InteractiveSession(): Session = {
    dynamic.InteractiveSession().as[Session]
  }

  def cond(c: Tensor, ifTrue: py.Object, ifFalse: py.Object): Tensor = {
    dynamic.cond(c, ifTrue, ifFalse).as[Tensor]
  }

  def contrib: Contrib = dynamic.contrib.as[Contrib]
}
