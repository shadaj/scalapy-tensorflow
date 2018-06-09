package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFacade, ObjectWriter, PyFunction, |}

// some TensorFlow operations require a LIST list, not just something iterable
class PythonList[T](o: py.Object)(implicit jep: Jep) extends py.Object(o.variableId)
object PythonList {
  implicit def seqToPythonList[T](seq: Seq[T])(implicit writer: ObjectWriter[Seq[T]], jep: Jep): PythonList[T] = {
    new PythonList(py.global.list(py.Object.from(seq)))
  }
}

class TensorFlow(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def Variable(initialValue: Tensor): Variable = native

  def random_uniform(shape: PythonList[Int], min: Double, max: Double): Tensor = native

  def placeholder(`type`: String): Tensor = native

  def placeholder(`type`: String, shape: Seq[py.NoneOr[Int]]): Tensor = native

  def nn: NeuralNetwork = native
  def train: Training = native

  def matmul(a: Tensor, b: Tensor): Tensor = native

  def identity: PyFunction = native

  def identity(t: Tensor): Tensor = native

  def zeros(shape: Seq[Int]): Tensor = native

  def reshape(tensor: Tensor, shape: PythonList[Int]): Tensor = native

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
