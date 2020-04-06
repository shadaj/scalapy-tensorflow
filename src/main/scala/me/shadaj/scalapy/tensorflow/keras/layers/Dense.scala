package me.shadaj.scalapy.tensorflow.keras
package layers

import me.shadaj.scalapy.py

@py.native trait Dense extends Layer {
  def units: Int = py.native
  def activation: py.NoneOr[String] = py.native
  def use_bias: Boolean = py.native
  def kernel_initializer: String = py.native
  def bias_initializer: String = py.native
  def kernel_regularizer: py.NoneOr[String] = py.native
  def bias_regularizer: py.NoneOr[String] = py.native
  def activity_regularizer: py.NoneOr[String] = py.native
  def kernel_constraint: py.NoneOr[String] = py.native
  def bias_constraint: py.NoneOr[String] = py.native
}