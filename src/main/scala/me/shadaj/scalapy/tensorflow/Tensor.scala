package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class Tensor(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def unary_+(): Tensor = {
    (+toDynamic).as[Tensor]
  }

  def unary_-(): Tensor = {
    (-toDynamic).as[Tensor]
  }

  def +(that: Tensor): Tensor = {
    (toDynamic + that).as[Tensor]
  }

  def -(that: Tensor): Tensor = {
    (toDynamic - that).as[Tensor]
  }

  def *(that: Tensor): Tensor = {
    (toDynamic * that).as[Tensor]
  }

  def /(that: Tensor): Tensor = {
    (toDynamic / that).as[Tensor]
  }
}
