import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    kotlin("kapt") version "1.9.23"
    // JPA 생성자 초기화 제거 용도
    kotlin("plugin.jpa") version "1.9.24"
}

group = "com.portfolio"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring Security
    implementation("org.springframework.boot:spring-boot-starter-security")
    // JJWT
    implementation("io.jsonwebtoken:jjwt:0.12.5")

    // DB - MySql
    runtimeOnly ("com.mysql:mysql-connector-j")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // jpa query logging
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.1")

    // QueryDSL
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

    // jasypt
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

    // Health Check
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // SWAGGER
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    // LOGGER
    implementation("org.slf4j:slf4j-api:2.0.13")


    // TEST
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("net.datafaker:datafaker:2.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    jvmArgs = listOf("-XX:+IgnoreUnrecognizedVMOptions", "-XX:+EnableDynamicAgentLoading")
    useJUnitPlatform()
}
