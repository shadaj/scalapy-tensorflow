package me.shadaj.scalapy.tensorflow

import me.shadaj.scalapy.py
import me.shadaj.scalapy.numpy.NumPy
import me.shadaj.scalapy.tensorflow.keras.Keras
import me.shadaj.scalapy.tensorflow.keras.datasets.Mnist
import me.shadaj.scalapy.tensorflow.keras.models.Sequential

object MnistExample extends App {
  val tf = py.module("tensorflow").as[TensorFlow]
  val np = py.module("numpy").as[NumPy]
  val kerasA = py.module("keras").as[Keras]
  val K = kerasA.backend
  val layers = kerasA.layers

  val batch_size = 128
  val num_classes = 10
  val epochs = 10

  val img_rows, img_cols = 28

  val mnist: Mnist  = kerasA.datasets.mnist
  val ((x_train, y_train), (x_test, y_test)) = mnist.load_data()

  val (train, test, input_shape) =
    if (K.image_data_format() == "channels_first") {
      val train = x_train.reshape(Seq(x_train.shape(0), 1, img_rows, img_cols))
      val test = x_test.reshape(Seq(x_test.shape(0), 1, img_rows, img_cols))
      val input_shape = (1, img_rows, img_cols)

      (train, test, input_shape)
    } else {
      val train = x_train.reshape(Seq(x_train.shape(0), img_rows, img_cols, 1))
      val test = x_test.reshape(Seq(x_test.shape(0), img_rows, img_cols, 1))
      val input_shape = (img_rows, img_cols, 1)

      (train, test, input_shape)
    }

  // TODO: not type safe
  val trainImages = train.astype(np.float32) / 255
  val testImages = test.astype(np.float32) / 255

  println(s"x_train shape: ${trainImages.shape}")
  println(s"${trainImages.shape(0)} train samples")
  println(s"${testImages.shape(0)} test samples")

  val trainLabels = kerasA.utils.to_categorical(y_train, num_classes)
  val testLabels = kerasA.utils.to_categorical(y_test, num_classes)

  val model = kerasA.models.Sequential()
  model.add(layers.Conv2D(filters = 32, kernel_size = (3, 3), activation = "relu", input_shape = input_shape))
  model.add(layers.Conv2D(filters = 64, kernel_size = (3, 3), activation = "relu"))
  model.add(layers.MaxPooling2D((2, 2)))
  model.add(layers.Dropout(0.25))
  model.add(layers.Flatten())
  model.add(layers.Dense(units = 128, activation="relu"))
  model.add(layers.Dropout(0.5))
  model.add(layers.Dense(units = num_classes, activation="softmax"))

  model.compile(
    loss = kerasA.losses.categorical_crossentropy,
    optimizer = kerasA.optimizers.Adadelta(),
    metrics = Seq("accuracy")
  )

  model.fit(
    x = trainImages,
    y = trainLabels,
    batch_size = batch_size,
    epochs = epochs,
    verbose = 1,
    validation_data = (testImages, testLabels))

  val score = model.evaluate(x = testImages, y = testLabels, verbose = 0)

  println(s"Test loss: ${score(0)}")
  println(s"Test accuracy: ${score(1)}")
}
