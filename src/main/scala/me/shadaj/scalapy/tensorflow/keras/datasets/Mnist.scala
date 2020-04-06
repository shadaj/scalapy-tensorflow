package me.shadaj.scalapy.tensorflow.keras.datasets

import me.shadaj.scalapy.py
import me.shadaj.scalapy.numpy.NDArray

@py.native trait Mnist extends py.Object {
  def load_data(path: String = "mnist.npz"): ((NDArray[Long], NDArray[Long]), (NDArray[Long], NDArray[Long])) = py.native
}
