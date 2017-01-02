package me.shadaj.scalapy

import jep.Jep

import me.shadaj.scalapy.numpy.NDArray

package object tensorflow {
  implicit def double2Tensor(d: Double)(implicit jep: Jep): Tensor = {
    py.Ref.from(d).as[Tensor]
  }

  implicit def nd2Tensor(nd: NDArray[Double])(implicit jep: Jep): Tensor = {
    py.Ref.from(nd).as[Tensor]
  }
}
