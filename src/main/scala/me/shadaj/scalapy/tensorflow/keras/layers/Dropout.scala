package me.shadaj.scalapy.tensorflow.keras
package layers

import me.shadaj.scalapy.py
import me.shadaj.scalapy.tensorflow.Tensor

@py.native trait Dropout extends Layer {
  def rate: Double = py.native
  def noise_shape: py.NoneOr[Tensor] = py.native
  def seed: py.NoneOr[Int] = py.native
}