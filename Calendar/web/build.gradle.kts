/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("Calendar.java-application-conventions")
}

dependencies {
    implementation(project(":services"))
}

application {
    // Define the main class for the application.
    mainClass.set("ua.nure.calendar.Application")
}
