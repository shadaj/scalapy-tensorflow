package me.shadaj.scalapy.tensorflow.keras.losses

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.PyFunction

@py.native trait Losses extends py.Object {
  def categorical_crossentropy: PyFunction = py.native
}
