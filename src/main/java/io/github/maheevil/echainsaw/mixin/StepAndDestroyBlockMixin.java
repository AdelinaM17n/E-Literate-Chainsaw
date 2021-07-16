package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StepAndDestroyBlockGoal.class)
public class StepAndDestroyBlockMixin extends MoveToTargetPosGoal {
    public StepAndDestroyBlockMixin(PathAwareEntity mob, double speed, int range, MobEntity stepAndDestroyMob, Block targetBlock) {
        super(mob, speed, range);
        this.stepAndDestroyMob = stepAndDestroyMob;
        this.targetBlock = targetBlock;
    }


    @Shadow @Final @Mutable
    private final MobEntity stepAndDestroyMob;

    @Shadow @Final @Mutable
    private final Block targetBlock;

    @Inject(
            method = "canStart",
            at = @At("RETURN"),
            cancellable = true
    )
    private void canStart(CallbackInfoReturnable<Boolean> cir){
        if(stepAndDestroyMob.getName().equals(EntityType.ZOMBIE.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.ZOMBIE_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }else if(stepAndDestroyMob.getName().equals(EntityType.ZOMBIFIED_PIGLIN.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.ZOMBIFIED_PIGLIN_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }else if(stepAndDestroyMob.getName().equals(EntityType.ZOMBIE_VILLAGER.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.ZOMBIE_VILLAGER_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }else if(stepAndDestroyMob.getName().equals(EntityType.DROWNED.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.DROWNED_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }else if(stepAndDestroyMob.getName().equals(EntityType.SKELETON.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.SKELENTON_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }else if(stepAndDestroyMob.getName().equals(EntityType.HUSK.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.HUSK_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }else if(stepAndDestroyMob.getName().equals(EntityType.STRAY.getName())
                && !this.stepAndDestroyMob.world.getGameRules().getBoolean(EChainsawMod.STRAY_MOB_GRIEFING)){
            cir.setReturnValue(false);
        }
    }

    //@Override
    @Shadow
    protected boolean isTargetPos(WorldView world, BlockPos pos) {
        return false;
    }


}