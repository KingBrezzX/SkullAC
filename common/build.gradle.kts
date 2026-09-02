import versioning.BuildConfig

plugins {
    `maven-publish`
    skull.`base-conventions`
}

repositories {
    val localOverride = if (BuildConfig.mavenLocalOverride) mavenLocal() else null

    // Skull API & PacketEvents
    val skullPublicReleases = maven("https://maven.skull.ac/public/releases") {
        mavenContent { releasesOnly() }
    }
    val skullPublicSnapshots = maven("https://maven.skull.ac/public/snapshots") {
        mavenContent { snapshotsOnly() }
    }
    val skullLegacySnapshots = maven("https://repo.skull.ac/snapshots")
    exclusiveContent {
        forRepositories(*listOfNotNull(localOverride, skullPublicReleases, skullPublicSnapshots, skullLegacySnapshots).toTypedArray())
        filter {
            includeGroup("me.kingbrezz.skullac.engine")
            includeGroup("com.github.retrooper")
        }
    }

    // ViaVersion
    exclusive("https://repo.viaversion.com", { mavenContent { releasesOnly() } }) {
        includeGroup("com.viaversion")
    }

    // Configuralize
    exclusive("https://nexus.scarsz.me/content/repositories/releases", { mavenContent { releasesOnly() } }) {
        includeGroup("github.scarsz")
    }

    // Cumulus
    exclusive("https://repo.opencollab.dev/maven-releases/", { mavenContent { releasesOnly() } }) {
        includeGroup("org.geysermc.api")
    }

    // Floodgate
    exclusive("https://repo.opencollab.dev/maven-snapshots/", { mavenContent { snapshotsOnly() } }) {
        includeGroup("org.geysermc.floodgate")
        includeGroup("org.geysermc.cumulus")
        includeModule("org.geysermc", "common")
        includeModule("org.geysermc", "geyser-parent")
    }

    mavenCentral()
}


dependencies {
    // compileOnly, not api: each platform bundles PE via its own JiJ/shade path,
    // so api() here would nest packetevents-api a second time (~4.2MB) in the jars.
    compileOnly(libs.packetevents.api)
    api(libs.cloud.core)
    api(libs.cloud.processors.requirements)
    api(libs.configuralize) {
        artifact {
            classifier = "slim"
        }
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    // Keep SnakeYAML current for server-side integrations
    api(libs.snakeyaml)
    api(libs.fastutil)
    api(libs.adventure.text.minimessage)
    api(libs.jetbrains.annotations)
    api(libs.hikaricp)
    runtimeOnly(libs.slf4j.jdk14)
    compileOnly(libs.mongoDriverSync)

    compileOnly(libs.geyser.base.api) {
        isTransitive = false // messes with guava otherwise
    }

    compileOnly(libs.floodgate.api)
    compileOnly(libs.viaversion)
    compileOnly(libs.viabackwards)
    compileOnly(libs.netty)
    compileOnly(libs.luckperms)

    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

publishing.publications.create<MavenPublication>("maven") {
    from(components["java"])
}

