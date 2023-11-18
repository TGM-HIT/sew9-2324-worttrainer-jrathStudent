plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    implementation("top.jfunc.json:json-gson:1.8.3")
    implementation("com.github.ramalapure:json-parser:1.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}