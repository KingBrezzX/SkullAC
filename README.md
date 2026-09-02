# SkullAC

**SkullAC — Advanced Server-Side Anti-Cheat**

Author: **KingBrezz**

Target platform: **Bukkit-compatible / Spigot-compatible / Paper 26.2**  
Java runtime: **25**  

SkullAC combines deterministic movement simulation, packet-level analysis, combat analysis, world replication, latency compensation, evidence correlation, and replay-based diagnostics into a single anti-cheat engine.

## Core architecture

- Server-authoritative movement simulation
- Packet-level validation
- Reach and combat analysis
- Bad-packet and packet-spam detection
- World-state replication and collision analysis
- Latency-aware prediction
- Cross-check correlation to reduce false positives
- Evidence/replay storage for staff investigation
- Configurable violation thresholds and mitigation
- Async-safe processing where supported
- Paper 26.2 compatibility

## Detection philosophy

SkullAC does not rely on a single signal for severe punishment. Suspicious behaviour is accumulated from independent evidence sources and evaluated using confidence, consistency, timing, latency, and player state.

The goal is high detection coverage **without turning normal lag, knockback, vehicles, or legitimate client behaviour into punishments**.

## Build

```bash
./gradlew :bukkit:shadowJar
```

The final Bukkit jar is produced under `bukkit/build/libs/`.

## Identity

Project: **SkullAC**  
Author: **KingBrezz**  
Package namespace: `me.kingbrezz.skullac`

## License

SkullAC is distributed under GPLv3-compatible terms. See `LICENSE` and `THIRD-PARTY-NOTICES.md` for the required third-party attribution and license information.
