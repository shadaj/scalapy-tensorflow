package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class Contrib(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def layers: Layers = native
}
