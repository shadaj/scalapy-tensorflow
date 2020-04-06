package me.shadaj.scalapy.tensorflow.keras

import scala.util.control.NonFatal
import me.shadaj.scalapy.py.{PyValue, Reader}
import me.shadaj.scalapy.py

package object layers {
  implicit val tupleReader: Reader[py.|[Int, (Int, Int)]] = new Reader[py.|[Int, (Int, Int)]] {
    override def read(v: PyValue): py.|[Int, (Int, Int)] = {
      try {
        v.getLong.toInt
      } catch {
        case NonFatal(_) =>
          val tuple = v.getTuple
          (tuple(0).getLong.toInt, tuple(1).getLong.toInt)
      }
    }
  }

  implicit def noneReader[T](implicit reader: Reader[T]): Reader[py.NoneOr[T]] = new Reader[py.NoneOr[T]] {
    override def read(v: PyValue): py.NoneOr[T] = {
      try {
        reader.read(v)
      } catch {
        // TODO: read None
        case NonFatal(_) => py.None
      }
    }
  }
}
