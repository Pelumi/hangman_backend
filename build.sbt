name := "HangmanLite"

version := "1.0"

lazy val `hangmanlite` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws, javaEbean, "mysql" % "mysql-connector-java" % "5.1.28" )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  