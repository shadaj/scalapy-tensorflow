package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class Training(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def ExponentialMovingAverage(decay: Double): ExponentialMovingAverage = {
    dynamic.ExponentialMovingAverage(decay).as[ExponentialMovingAverage]
  }

  def GradientDescentOptimizer(learningRate: Double): Optimizer = {
    dynamic.GradientDescentOptimizer(learningRate).as[Optimizer]
  }

  def AdamOptimizer(lr: Double): Optimizer = {
    dynamic.AdamOptimizer(lr).as[Optimizer]
  }
}
