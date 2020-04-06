package me.shadaj.scalapy.tensorflow.keras
package models

import me.shadaj.scalapy.py
import me.shadaj.scalapy.tensorflow.keras.layers.Layer
import me.shadaj.scalapy.numpy.NDArray
import me.shadaj.scalapy.py.PyFunction
import me.shadaj.scalapy.tensorflow.keras.optimizers.Optimizer

@py.native trait Sequential extends py.Object {
  private val origDynamic = this.as[py.Dynamic]

  def add(layer: Layer): Unit = origDynamic.add(layer = layer).as[Unit]

  def compile(optimizer: py.|[String, Optimizer] = "rmsprop",
              loss: py.NoneOr[PyFunction] = py.None,
              metrics: Seq[String] = Seq.empty,
              loss_weights: Seq[(Double, Double)] = Seq.empty,
              sample_weight_mode: py.NoneOr[String] = py.None,
              weighted_metrics: Seq[String] = Seq.empty,
              target_tensors: py.NoneOr[String] = py.None
             ) = origDynamic.compile(optimizer = optimizer, loss = loss, metrics = metrics, loss_weights = loss_weights, sample_weight_mode = sample_weight_mode, weighted_metrics = weighted_metrics, target_tensors = target_tensors).as[Unit]

  def fit(x: NDArray[Long],
          y: NDArray[Long],
          batch_size: py.NoneOr[Int] = py.None,
          epochs: Int = 1,
          verbose: Int = 1,
          validation_data: py.NoneOr[(NDArray[Long], NDArray[Long])] = py.None
         ): Unit = origDynamic.fit(x = x, y = y, batch_size = batch_size, epochs = epochs, verbose = verbose, validation_data = validation_data).as[Unit]

  def evaluate(x: NDArray[Long],
               y: NDArray[Long],
               batch_size: py.NoneOr[Int] = py.None,
               verbose: Int = 1
              ): Seq[Double] = origDynamic.evaluate(x = x, y = y, batch_size = batch_size, verbose = verbose).as[Seq[Double]]
}