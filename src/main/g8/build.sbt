name := "pekko-quickstart-java"

version := "1.0"

scalaVersion := "2.13.16"

lazy val pekkoVersion = "$pekko_version$"

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor-typed" % pekkoVersion,
  "org.apache.pekko" %% "pekko-actor-testkit-typed" % pekkoVersion,
  "ch.qos.logback" % "logback-classic" % "1.3.15",
  "junit" % "junit" % "4.13.2" % Test,
  "com.github.sbt" % "junit-interface" % "0.13.2" % Test)
