package me.shadaj.scalapy.tensorflow.keras.backend

import me.shadaj.scalapy.py

@py.native trait Backend extends py.Object {
 def image_data_format(): String = py.native
}

