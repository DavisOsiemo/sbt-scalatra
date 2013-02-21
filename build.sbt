organization := "org.scalatra.sbt"

name := "scalatra-sbt"

sbtPlugin := true

publishMavenStyle := false

version := "0.1.3"

scalacOptions ++= Seq("-unchecked", "-deprecation")

javacOptions ++= Seq("-target", "1.6", "-source", "1.6")

publishTo <<= (version) { version: String =>
   val scalasbt = "http://scalasbt.artifactoryonline.com/scalasbt/"
   val (name, url) = if (version.contains("-SNAPSHOT"))
                       ("sbt-plugin-snapshots", scalasbt+"sbt-plugin-snapshots")
                     else
                       ("sbt-plugin-releases", scalasbt+"sbt-plugin-releases")
   Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
}

libraryDependencies ++= Seq(
  "com.github.siasia" %% "xsbt-web-plugin" % "0.12.0-0.2.11.1"
)