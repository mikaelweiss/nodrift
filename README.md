# NoDrift

A client-side Fabric mod that tames the drift of creative-mode flight. Release the movement keys and you stop — with exactly as much glide as you want, configurable from full vanilla drift down to an instant stop.

Built for Minecraft **26.1 – 26.2**.

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

Uploads the built jar as a new version of the [no-drift](https://modrinth.com/mod/no-drift) project and syncs the project description from `MODRINTH.md`.

### Set the environment on every new version

Minotaur does not set Modrinth's per-version environment metadata, so after each upload you must set it by hand or the version will be labeled inaccurately (Modrinth flags this under section 5.1 of its content rules). On the Modrinth site, open the new version under the **Versions** tab, go to **Version settings**, and set **Environment** to **Client-side only**. NoDrift runs entirely on the client and works on any server, including vanilla, so that is always the correct value.

## License

[CC0-1.0](LICENSE) — public domain. Do whatever you like with it.
