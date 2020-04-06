package me.shadaj.scalapy.tensorflow.keras.layers

import me.shadaj.scalapy.py
import me.shadaj.scalapy.tensorflow.Tensor

@py.native trait Layers extends py.Object {
  def Conv2D(filters: Int,
             kernel_size: py.|[Int, (Int, Int)],
             strides: py.|[Int, (Int, Int)] = (1, 1),
             padding: String = "valid",
             data_format: py.NoneOr[String] = py.None,
             dilation_rate: py.|[Int, (Int, Int)] = (1, 1),
             activation: py.NoneOr[String] = py.None,
             use_bias: Boolean = true,
             kernel_initializer: String = "glorot_uniform",
             bias_initializer: String = "zeros",
             kernel_regularizer: py.NoneOr[String] = py.None,
             bias_regularizer: py.NoneOr[String] = py.None,
             activity_regularizer: py.NoneOr[String] = py.None,
             kernel_constraint: py.NoneOr[String] = py.None,
             bias_constraint: py.NoneOr[String] = py.None,
             input_shape: py.NoneOr[(Int, Int, Int)] = py.None
            ): Conv2D = py.nativeNamed

  def Dropout(rate: Double,
              noise_shape: py.NoneOr[Tensor] = py.None,
              seed: py.NoneOr[Int] = py.None
             ): Dropout = py.nativeNamed

  def MaxPooling2D(pool_size: (Int, Int),
                   strides: py.NoneOr[py.|[Int, (Int, Int)]] = py.None,
                   padding: String = "valid",
                   data_format: py.NoneOr[String] = py.None
                  ): MaxPooling2D = py.nativeNamed

  def Flatten(data_format: py.NoneOr[String] = py.None): Flatten = py.nativeNamed

  def Dense(units: Int,
            activation: py.NoneOr[String] = py.None,
            use_bias: Boolean = true,
            kernel_initializer: String = "glorot_uniform",
            bias_initializer: String = "zeros",
            kernel_regularizer: py.NoneOr[String] = py.None,
            bias_regularizer: py.NoneOr[String] = py.None,
            activity_regularizer: py.NoneOr[String] = py.None,
            kernel_constraint: py.NoneOr[String] = py.None,
            bias_constraint: py.NoneOr[String] = py.None
           ): Dense = py.nativeNamed
}
