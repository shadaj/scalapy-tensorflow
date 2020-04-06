package me.shadaj.scalapy.tensorflow.keras.models

import me.shadaj.scalapy.py

@py.native trait Models extends py.Object {
  def Sequential(): Sequential = py.native
}
