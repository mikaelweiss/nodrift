package dev.mikael.nodrift.mixin;

import dev.mikael.nodrift.NoDriftConfig;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {

	@Inject(method = "aiStep", at = @At("TAIL"))
	private void nodrift$dampenFlightDrift(CallbackInfo ci) {
		double factor = NoDriftConfig.driftStrength();
		if (factor >= 1.0) {
			return;
		}
		LocalPlayer player = (LocalPlayer) (Object) this;
		if (!player.getAbilities().flying) {
			return;
		}
		Vec3 motion = player.getDeltaMovement();
		double x = motion.x;
		double y = motion.y;
		double z = motion.z;
		var move = player.input.getMoveVector();
		if (Math.abs(move.x) <= Mth.EPSILON && Math.abs(move.y) <= Mth.EPSILON) {
			x *= factor;
			z *= factor;
		}
		var keys = player.input.keyPresses;
		if (!keys.jump() && !keys.shift()) {
			y *= factor;
		}
		if (x != motion.x || y != motion.y || z != motion.z) {
			player.setDeltaMovement(x, y, z);
		}
	}
}
