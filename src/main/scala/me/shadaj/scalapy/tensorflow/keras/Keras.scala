package me.shadaj.scalapy.tensorflow.keras

import me.shadaj.scalapy.py
import me.shadaj.scalapy.tensorflow.keras.backend.Backend
import me.shadaj.scalapy.tensorflow.keras.datasets.Datasets
import me.shadaj.scalapy.tensorflow.keras.models.Models
import me.shadaj.scalapy.tensorflow.keras.optimizers.Optimizers
import me.shadaj.scalapy.tensorflow.keras.utils.Utils
import me.shadaj.scalapy.tensorflow.keras.losses.Losses
import me.shadaj.scalapy.tensorflow.keras.layers.Layers


@py.native trait Keras extends py.Object {
  def models: Models = py.native
  def datasets: Datasets = py.native
  def backend: Backend = py.native
  def utils: Utils = py.native
  def optimizers: Optimizers = py.native
  def losses: Losses = py.native
  def layers: Layers = py.native
}
