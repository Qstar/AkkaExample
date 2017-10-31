name := "AkkaExample"

version := "0.1"

scalaVersion := "2.10.6"

resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Sonatype OSS Snapshots Repository" at "http://oss.sonatype.org/content/groups/public",
  "Apache" at "http://maven.apache.org",
  "gphat" at "https://raw.github.com/gphat/mvn-repo/master/releases/",
  "Redis Maven" at "https://dl.bintray.com/spark-packages/maven",
  "Alibaba" at "https://mvnrepository.com/artifact/com.alibaba",
  "Sohu public" at "http://10.11.159.110:8082/nexus/content/groups/public/",
  "Sohu central" at "http://10.11.159.110:8082/nexus/content/repositories/central/",
  "Sohu apache" at "http://10.11.159.110:8082/nexus/content/repositories/apache-release/"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.10" % "2.3.16",
  "com.typesafe.akka" % "akka-testkit_2.10" % "2.3.16" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0"
)