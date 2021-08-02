package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$EatCarrotCropGoal")
public class EatCarrotCropGoalMixin {
    @Shadow @Final
    private RabbitEntity rabbit;

    @Redirect(
            method = "Lnet/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal;canStart()Z",
            at = @At(value = "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    private boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!this.rabbit.world.getGameRules().getBoolean(EChainsawMod.MOB_CROP_HARVEST))
            return false;
        return this.rabbit.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
    }
}
