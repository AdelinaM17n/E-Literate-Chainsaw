package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net/minecraft/entity/mob/SilverfishEntity$CallForHelpGoal")
public class SilverFishEntityCallForHelpMixin extends Goal {
    @Shadow
    public boolean canStart() {
        return false;
    }

    @Redirect(
            method = "Lnet/minecraft/entity/mob/SilverfishEntity$CallForHelpGoal;tick()V",
            at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    public boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!gameRules.getBoolean(EChainsawMod.HOSTILE_MOB_BLOCK_DAMAGE))
            return false;
        return gameRules.getBoolean(GameRules.DO_MOB_GRIEFING);
    }
}
