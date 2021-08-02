package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.FarmerVillagerTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(FarmerVillagerTask.class)
public class FarmerVillagerTaskMixin extends Task<VillagerEntity> {

    public FarmerVillagerTaskMixin(Map<MemoryModuleType<?>, MemoryModuleState> requiredMemoryState) {
        super(requiredMemoryState);
    }

    @Inject(
            method = "shouldRun",
            at = @At("RETURN"),
            cancellable = true
    )
    protected void shouldRun(ServerWorld serverWorld, VillagerEntity villagerEntity, CallbackInfoReturnable<Boolean> cir) {
        if(!serverWorld.getGameRules().getBoolean(EChainsawMod.MOB_CROP_HARVEST)){
            cir.setReturnValue(false);
        }
    }
}
