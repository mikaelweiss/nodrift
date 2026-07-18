# NoDrift

A client-side Fabric mod that tames the drift of creative-mode flight. Release the movement keys and you stop — with exactly as much glide as you want, configurable from full vanilla drift down to an instant stop.

Built for Minecraft **26.1 – 26.1.2**.

![icon](icon-512.png)

## How it works

A mixin at the tail of `LocalPlayer.aiStep` multiplies the player's residual velocity by the configured drift strength each tick while creative-style flight is active and the corresponding movement keys are released. `1.0` leaves vanilla behavior untouched; `0.0` zeroes momentum outright. The default is `0.4`, which leaves roughly half a block of glide.

The slider lives in the mod's settings screen, reachable through [Mod Menu](https://modrinth.com/mod/modmenu) (optional — compile-time dependency only). The value persists in `config/nodrift.json`. There are no runtime dependencies, not even Fabric API.

## Building

```sh
./gradlew build
```

The jar lands in `build/libs/`. Requires Java 25.

## Publishing to Modrinth

```sh
MODRINTH_TOKEN=<your-token> ./gradlew modrinth
```

Uploads the built jar as a new version of the [nodrift](https://modrinth.com/mod/nodrift) project and syncs the project description from `MODRINTH.md`.

## License

[CC0-1.0](LICENSE) — public domain. Do whatever you like with it.
