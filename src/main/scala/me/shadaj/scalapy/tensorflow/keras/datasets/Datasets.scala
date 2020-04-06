package me.shadaj.scalapy.tensorflow.keras.datasets

import me.shadaj.scalapy.py

@py.native trait Datasets extends py.Object {
  def mnist: Mnist = py.native
}
