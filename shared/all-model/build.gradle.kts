plugins {
  id("my.kotlin-jvm-lib")
}

dependencies {
  api(platform("org.springframework.boot:spring-boot-dependencies"))
  api("com.fasterxml.jackson.core:jackson-databind")
}