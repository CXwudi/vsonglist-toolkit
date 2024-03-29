plugins {
  id("my.kotlin-jvm-lib")
}

dependencies {
  implementation(project(":shared:all-model"))
  api(project(":component:io-api"))
  api(project(":component:http-service-api"))
  api("com.github.CXwudi:kotlin-jvm-inline-logging")
}