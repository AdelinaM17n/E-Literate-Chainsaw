package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net/minecraft/entity/mob/SilverfishEntity$WanderAndInfestGoal")
public class SilverFishEntityInfestMixin extends WanderAroundGoal {
    public SilverFishEntityInfestMixin(PathAwareEntity mob, double speed) {
        super(mob, speed);
    }

    @Redirect(
            method = "Lnet/minecraft/entity/mob/SilverfishEntity$WanderAndInfestGoal;canStart()Z",
            at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    public boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!gameRules.getBoolean(EChainsawMod.HOSTILE_MOB_BLOCK_DAMAGE))
            return false;
        return gameRules.getBoolean(GameRules.DO_MOB_GRIEFING);
    }

}
