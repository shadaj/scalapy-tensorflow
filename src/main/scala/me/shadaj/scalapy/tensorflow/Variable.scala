package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py

class Variable(o: py.Object)(implicit jep: Jep) extends Tensor(o)
