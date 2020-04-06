import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}
import scala.sys.process._

organization in ThisBuild := "me.shadaj"

scalaVersion in ThisBuild := "2.12.10"

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
    libraryDependencies += "me.shadaj" %%% "scalapy-core" % "0.3.0+17-2bfe86de",
    // TODO: update to released scalapy-numpy
    libraryDependencies += "me.shadaj" %%% "scalapy-numpy" % "0.1.0+5-ad550211+20200401-1343",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0-SNAP8" % Test
  ).jvmSettings(
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
    fork in Test := true,
      javaOptions in Test += s"-Djna.library.path=${"python3-config --prefix".!!.trim}/lib"
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
