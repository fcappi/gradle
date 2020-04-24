// Define Java Library conventions for this project.
// Projects need to use the organization's Java conventions and publish using Maven Publish

// tag::plugins[]
plugins {
    `java-library`
    `maven-publish`
    id("com.example.java-convention")
}
// end::plugins[]

// Libraries have the 'com.example' group by convention
group = "com.example"

publishing {
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "myOrgPrivateRepo"
            url = uri("build/my-repo")
        }
    }
}

// The project requires libraries to have a README containing sections configured below
// tag::use-java-class[]
val readmeCheck by tasks.registering(com.example.ReadmeVerificationTask::class) {
    readme.set(layout.projectDirectory.file("README.md"))
    readmePatterns.set(listOf("^## API$", "^## Changelog$"))
}
// end::use-java-class[]

tasks.named("check") { dependsOn(readmeCheck) }
