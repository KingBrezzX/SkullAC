# SkullAC 4.0

SkullAC 4.0 is a single anti-cheat project under the **KingBrezz** identity.

Supported runtime: Bukkit / Spigot-compatible servers, Paper 26.2, and Folia-compatible Paper forks.

The implementation combines the project's own analysis, correlation, evidence, replay, and mitigation layers with a GPLv3-compatible third-party codebase that has been substantially integrated and reworked into the SkullAC namespace and lifecycle.

## Runtime model

- One Bukkit plugin: `SkullAC`
- Main class: `me.kingbrezz.skullac.SkullAC`
- Commands: `/skullac` and `/sus`
- Paper target: 26.2
- Java target: 25
- PacketEvents lifecycle is owned by SkullAC
- Detection evidence is correlated before strong mitigation

## Important

SkullAC should be benchmarked against legitimate movement, high latency, ViaVersion, Geyser/Floodgate, vehicles, knockback, block collisions, and common cheat behaviour before production auto-punishment is enabled.

Third-party GPLv3 attribution and licensing information is retained in `THIRD-PARTY-NOTICES.md` and `LICENSE`.
