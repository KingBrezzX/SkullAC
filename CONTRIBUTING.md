# Contributing to SkullAC

Thank you for contributing to SkullAC.

## Development

SkullAC is a Gradle Kotlin project targeting modern Minecraft server platforms. For the Paper 26.2 build, use Java 25.

Before submitting changes:

1. Keep the package namespace under `me.kingbrezz.skullac`.
2. Keep public behaviour backwards compatible unless the change is intentional.
3. Add or update tests for detection logic where practical.
4. Avoid blocking the server thread with expensive work.
5. Document changes that affect configuration, checks, or permissions.
6. Preserve all required third-party license and attribution notices.

## Anti-cheat changes

Detection changes should prioritize deterministic evidence, latency tolerance, and low false-positive rates. New checks should be tested against legitimate movement before enabling automatic punishment.

## Build

```bash
./gradlew :bukkit:shadowJar
```

## Author

SkullAC is maintained under the **KingBrezz** project identity.
