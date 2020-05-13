import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

organization in ThisBuild := "me.shadaj"

scalaVersion in ThisBuild := "2.12.8"

Compile / scalaSource := baseDirectory.value / "src" /  "main" / "scala"

Test / scalaSource := baseDirectory.value / "src" / "test" / "scala"

// dependencies for scalapy-tensorflow-source
libraryDependencies += "me.shadaj" %%% "scalapy-core" % "0.3.0"
libraryDependencies += "me.shadaj" %%% "scalapy-numpy" % "0.1.0+3-046d1d67"
libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0-SNAP8" % Test


addCommandAlias(
  "publishSignedAll",
  (scalaPyTensorFlow: ProjectDefinition[ProjectReference])
    .aggregate
    .map(p => s"+ ${p.asInstanceOf[LocalProject].project}/publishSigned")
    .mkString(";", ";", "")
)

lazy val scalaPyTensorFlow = project.in(file(".")).aggregate(
  scalaPyTensorFlowJVM,
  scalaPyTensorFlowNative
).settings(
  publish := {},
  publishLocal := {},
  scalaSource in Compile := baseDirectory.value / "no-src",
  scalaSource in Test := baseDirectory.value / "no-src"
)

lazy val scalaPyTensorFlowCross = crossProject(JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    name := "scalapy-tensorflow",
    libraryDependencies += "me.shadaj" %%% "scalapy-core" % "0.3.0",
    libraryDependencies += "me.shadaj" %%% "scalapy-numpy" % "0.1.0+3-046d1d67",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0-SNAP8" % Test
  ).jvmSettings(
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
    fork in Test := true,
    javaOptions in Test += s"-Djava.library.path=${sys.env.getOrElse("JEP_PATH", "/usr/local/lib/python3.7/site-packages/jep")}"
  ).nativeSettings(
    scalaVersion := "2.11.12",
    libraryDependencies += "com.github.lolgab" %%% "scalacheck" % "1.14.1" % Test,
    nativeLinkStubs := true,
    nativeLinkingOptions ++= {
      import scala.sys.process._
      "python3-config --ldflags".!!.split(' ').map(_.trim).filter(_.nonEmpty).toSeq
    }
  )

lazy val scalaPyTensorFlowJVM = scalaPyTensorFlowCross.jvm
lazy val scalaPyTensorFlowNative = scalaPyTensorFlowCross.native
