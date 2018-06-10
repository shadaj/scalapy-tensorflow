organization := "me.shadaj"

name := "scalapy-tensorflow"

scalaVersion := "2.12.6"

fork in Test := true

javaOptions in Test += "-Djava.library.path=/usr/local/lib/python3.6/site-packages/jep"

libraryDependencies += "me.shadaj" %% "scalapy-numpy" % "0.1.0"
