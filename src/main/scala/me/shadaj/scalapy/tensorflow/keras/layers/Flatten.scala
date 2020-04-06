package me.shadaj.scalapy.tensorflow.keras.layers

import me.shadaj.scalapy.py

@py.native trait Flatten extends Layer {
  def data_format: py.NoneOr[String] = py.native
}