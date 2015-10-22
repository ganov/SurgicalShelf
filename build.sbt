name := """SurgicalShelf"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  //WebJar Tools
  "org.webjars" %% "webjars-play" % "2.3.0-3",
  //AngularJS
  "org.webjars" % "angularjs" % "1.4.7",
  "org.webjars" % "angular-ui-bootstrap" % "0.14.0",
  // Modernizr
  "org.webjars" % "modernizr" % "2.8.3",
  //html5shiv
  "org.webjars" % "html5shiv" % "3.7.3",
  // Twitter Bootstrap
  "org.webjars" % "bootstrap" % "3.3.5",
  // Font Awesome
  "org.webjars" % "font-awesome" % "4.4.0",
  //animate CSS Kool effect JQuery
  "org.webjars" % "animate.css" % "3.3.0"
)

LessKeys.compress in Assets := true

pipelineStages := Seq(digest, gzip)

includeFilter in (Assets, LessKeys.less) := "*.less"

lazy val root = (project in file(".")).enablePlugins(PlayJava)