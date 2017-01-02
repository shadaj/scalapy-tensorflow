package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class Contrib(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def layers: Layers = dynamic.layers.as[Layers]
}
