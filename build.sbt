name := "backend-refactoring-exercise"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "19.8.0",
  "org.json4s" %% "json4s-core" % "3.6.7",
  "org.json4s" %% "json4s-jackson" % "3.6.7"
)
