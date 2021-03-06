package com.typesafe.jse.sbt

import sbt._

/**
 * Declares the main parts of a WebDriver based plugin for sbt.
 */
object JsEnginePlugin extends sbt.Plugin {

  object JsEngineKeys {

    object EngineType extends Enumeration {
      val CommonNode, Node, PhantomJs, Rhino, Trireme = Value
    }

    val engineType = SettingKey[EngineType.Value]("jse-type", "The type of engine to use.")
    val parallelism = SettingKey[Int]("jse-parallelism", "The number of parallel tasks for the JavaScript engine. Defaults to the # of available processors + 1 to keep things busy.")
  }

  import JsEngineKeys._

  def jsEngineSettings: Seq[Setting[_]] = Seq(
    engineType := EngineType.Trireme,
    parallelism := java.lang.Runtime.getRuntime.availableProcessors() + 1
  )

}
