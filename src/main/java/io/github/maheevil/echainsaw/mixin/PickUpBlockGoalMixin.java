package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(targets = "net.minecraft.entity.mob.EndermanEntity$PickUpBlockGoal")
public class PickUpBlockGoalMixin {
    @Shadow @Final private EndermanEntity enderman;

    @Inject(
            method = "Lnet/minecraft/entity/mob/EndermanEntity$PickUpBlockGoal;canStart()Z",
            at = @At("RETURN"),
            cancellable = true
    )
    public void canStart(CallbackInfoReturnable<Boolean> cir){
        if(!this.enderman.world.getGameRules().getBoolean(EChainsawMod.ENDERMAN_BLOCK_GRIEFING)){
            cir.setReturnValue(false);
        }
    }

}
