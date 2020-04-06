package me.shadaj.scalapy.tensorflow.keras
package layers

import me.shadaj.scalapy.py

@py.native trait Conv2D extends Layer {
  def filters: Int = py.native
  def kernel_size: py.|[Int, (Int, Int)] = py.native
  def strides: py.|[Int, (Int, Int)] = py.native
  def padding: String = py.native
  def data_format: py.NoneOr[String] = py.native
  def dilation_rate: py.|[Int, (Int, Int)] = py.native
  def activation: py.NoneOr[String] = py.native
  def use_bias: Boolean = py.native
  def kernel_initializer: String = py.native
  def bias_initializer: String = py.native
  def kernel_regularizer: py.NoneOr[String] = py.native
  def bias_regularizer: py.NoneOr[String] = py.native
  def activity_regularizer: py.NoneOr[String] = py.native
  def kernel_constraint: py.NoneOr[String] = py.native
  def bias_constraint: py.NoneOr[String] = py.native
  def input_shape: py.NoneOr[(Int, Int, Int)] = py.native
}