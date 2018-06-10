package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFacade, PyFunction}

class Layers(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def batch_norm(inputs: Tensor, decay: Double, center: Boolean, scale: Boolean, epsilon: Double,
                 activation_fn: py.NoneOr[PyFunction], updates_collections: py.NoneOr[py.Object],
                 is_training: Boolean, reuse: py.NoneOr[Boolean], scope: py.NoneOr[String]): Tensor = nativeNamed

  def flatten(inputs: Tensor): Tensor = native
}
