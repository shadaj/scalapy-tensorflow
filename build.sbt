organization := "me.shadaj"

name := "scalapy-tensorflow"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.1"

fork in runMain := true
fork in run in Test := true

javaOptions in run in Test += "-Djava.library.path=./lib/"
javaOptions in runMain += "-Djava.library.path=./lib/"

libraryDependencies += "me.shadaj" %% "scalapy" % "0.1.0-SNAPSHOT"
libraryDependencies += "me.shadaj" %% "scalapy-numpy" % "0.1.0-SNAPSHOT"