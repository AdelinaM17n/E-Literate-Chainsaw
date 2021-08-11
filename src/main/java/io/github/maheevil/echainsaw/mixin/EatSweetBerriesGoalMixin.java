package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net/minecraft/entity/passive/FoxEntity$EatSweetBerriesGoal")
public class EatSweetBerriesGoalMixin extends MoveToTargetPosGoal {
    public EatSweetBerriesGoalMixin(PathAwareEntity mob, double speed, int range) {
        super(mob, speed, range);
    }

    @Redirect(
            method = "Lnet/minecraft/entity/passive/FoxEntity$EatSweetBerriesGoal;eatSweetBerry()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    public boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!gameRules.getBoolean(EChainsawMod.MOB_CROP_HARVEST))
            return false;
        return gameRules.getBoolean(GameRules.DO_MOB_GRIEFING);
    }

    @Shadow
    protected boolean isTargetPos(WorldView world, BlockPos pos) {
        return false;
    }
}
