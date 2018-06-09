package me.shadaj.scalapy.tensorflow

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class Training(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def ExponentialMovingAverage(decay: Double): ExponentialMovingAverage = native

  def GradientDescentOptimizer(learningRate: Double): Optimizer = native

  def AdamOptimizer(lr: Double): Optimizer = native
}
