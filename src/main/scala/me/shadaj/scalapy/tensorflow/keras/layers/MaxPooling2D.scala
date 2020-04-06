package me.shadaj.scalapy.tensorflow.keras.layers

import me.shadaj.scalapy.tensorflow.Tensor
import me.shadaj.scalapy.py

@py.native trait MaxPooling2D extends Layer {
  def pool_size: (Int, Int) = py.native
  def strides: py.NoneOr[py.|[Int, (Int, Int)]] = py.native
  def padding: String = py.native
  def data_format: py.NoneOr[String] = py.native
}