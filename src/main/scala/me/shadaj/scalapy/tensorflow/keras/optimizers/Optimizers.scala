package me.shadaj.scalapy.tensorflow.keras.optimizers

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{PyValue, Reader}

@py.native trait Optimizers extends py.Object {
  def Adadelta(): Adadelta = py.native
}

@py.native trait Optimizer extends py.Object

@py.native class Adadelta(val value: PyValue) extends Optimizer

object Adadelta {
  implicit val reader: Reader[Adadelta] = new Reader[Adadelta] {
    override def read(v: PyValue): Adadelta = new Adadelta(v)
  }
}