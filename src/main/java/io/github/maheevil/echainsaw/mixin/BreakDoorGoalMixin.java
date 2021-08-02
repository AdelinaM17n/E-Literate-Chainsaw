package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.DoorInteractGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BreakDoorGoal.class)
public class BreakDoorGoalMixin extends DoorInteractGoal {

    public BreakDoorGoalMixin(MobEntity mob) {
        super(mob);
    }

    @Redirect(
            method = "canStart",
            at = @At(value = "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    private boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!this.mob.world.getGameRules().getBoolean(EChainsawMod.MOB_DOOR_BREAKING))
            return false;
        return this.mob.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
    }
}
