package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.CropBlock;
import net.minecraft.block.PlantBlock;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CropBlock.class)
public class CropBlockMixin extends PlantBlock {
    protected CropBlockMixin(Settings settings) {
        super(settings);
    }

    @Redirect(
            method = "onEntityCollision",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    public boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!gameRules.getBoolean(EChainsawMod.MOB_ENTITY_COLLISION_BlOCK_GRIEFING))
            return false;
        return gameRules.getBoolean(GameRules.DO_MOB_GRIEFING);
    }
}
