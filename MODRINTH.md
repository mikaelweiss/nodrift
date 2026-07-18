# NoDrift

**Creative flight that stops when you do.**

In vanilla Minecraft, letting go of the movement keys while flying in creative mode sends you sliding for another eight to ten blocks. That's fine for cruising, but it's miserable for building. Lining up with a block, placing while hovering, or flying with a controller all turn into a fight against momentum.

NoDrift dampens that glide to whatever amount you actually want, from full vanilla drift all the way down to a dead stop.

## Features

- **Stop where you mean to.** Release the keys and your glide ends in a fraction of a second instead of half a chunk.
- **A single slider.** Open the mod's settings through [Mod Menu](https://modrinth.com/mod/modmenu) and slide between **Vanilla** (untouched) and **None** (instant stop). The default keeps just a touch of drift so flying still feels natural.
- **Vertical too.** Releasing jump or sneak settles your altitude the same way.
- **Tiny and dependency-free.** A single small mixin, no Fabric API required, no keybinds, nothing running when you aren't flying.
- **Client-side only.** Works in singleplayer and on any server, vanilla servers included. Only creative-style flight is affected; walking, sprinting, elytra, and everything else stay untouched.

## Settings

Requires [Mod Menu](https://modrinth.com/mod/modmenu) to open the settings screen (the mod works without it, you just can't change the slider). Your choice is saved to `config/nodrift.json`.

| Slider         | Feel                                                 |
| -------------- | ---------------------------------------------------- |
| Vanilla        | The full ~10-block glide                             |
| ~40% (default) | About half a block of glide — noticeable, not floaty |
| None           | Instant stop the moment you let go                   |

## Support

Found a problem on a new Minecraft version? [Open an issue](https://github.com/mikaelweiss/nodrift/issues).
