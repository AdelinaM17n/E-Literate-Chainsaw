package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.Block;
import net.minecraft.block.TurtleEggBlock;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TurtleEggBlock.class)
public class TurtleEggBlockMixin extends Block {
    public TurtleEggBlockMixin(Settings settings) {
        super(settings);
    }
    @Redirect(
            method = "breaksEgg",
            at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    public boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!gameRules.getBoolean(EChainsawMod.UNDEAD_MOBS_TURTLE_EGG_GRIEFING))
            return false;
        return gameRules.getBoolean(GameRules.DO_MOB_GRIEFING);
    }
}
