package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EatGrassGoal.class)
public class EatGrassGoalMixin extends Goal {
    @Shadow
    public boolean canStart() {
        return false;
    }

    @Shadow @Final private MobEntity mob;

    @Shadow @Final private World world;

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0))
    private boolean redirectDoMobGriefing1(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule) {
        return false;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 1))
    private boolean redirectDoMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule) {
        return false;
    }


    /*@ModifyVariable(
            method = "tick",
            at = @At("STORE"),
            ordinal = 0
    )
    private BlockPos blockPos(BlockPos blockPos){
        if(this.mob instanceof SheepEntity
                && this.world.getGameRules().getBoolean(EChainsawMod.SHEEP_MOB_GRIEFING))
            return blockPos.withY(257);
        return blockPos;
    }

    @ModifyVariable(
            method = "tick",
            at = @At("STORE"),
            ordinal = 1
    )
    private BlockPos blockPos2(BlockPos blockPos2){
        if(this.mob instanceof SheepEntity
                && this.world.getGameRules().getBoolean(EChainsawMod.SHEEP_MOB_GRIEFING))
            return blockPos2.withY(257);
        return blockPos2;
    }*/
}
