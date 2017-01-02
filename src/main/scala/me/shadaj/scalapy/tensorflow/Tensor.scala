package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class Tensor(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def unary_+(): Tensor = {
    (+dynamic).as[Tensor]
  }

  def unary_-(): Tensor = {
    (-dynamic).as[Tensor]
  }

  def +(that: Tensor): Tensor = {
    (dynamic + that).as[Tensor]
  }

  def -(that: Tensor): Tensor = {
    (dynamic - that).as[Tensor]
  }

  def *(that: Tensor): Tensor = {
    (dynamic * that).as[Tensor]
  }

  def /(that: Tensor): Tensor = {
    (dynamic / that).as[Tensor]
  }
}
