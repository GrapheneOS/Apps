plugins {
    id("com.android.application") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("androidx.navigation.safeargs") version "2.6.0" apply false
}

allprojects {
    tasks.withType<JavaCompile> {
        val compilerArgs = options.compilerArgs
        compilerArgs.add("-Xlint:unchecked")
        compilerArgs.add("-Xlint:deprecation")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.freeCompilerArgs = listOf(
            "-opt-in=kotlin.RequiresOptIn"
        )
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
