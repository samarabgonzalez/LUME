plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    // plugin KSP imprescindible para procesar las anotaciones de Room
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.lume"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.lume"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // … las que trae la plantilla, sin tocarlas …
    debugImplementation(libs.androidx.compose.ui.tooling)

    // - Dependencias añadidas a mano para Percha -
    // Room: runtime (la librería), ktx (soporte de corrutinas y Flow) y
    // compiler, que se usa con ksp( .) porque solo trabaja al compilar.
    val roomVersion = "2.8.5"
    implementation("androidx.room:room-runtime:${roomVersion}")
    implementation("androidx.room:room-ktx:${roomVersion}")
    ksp("androidx.room:room-compiler:$roomVersion")

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}