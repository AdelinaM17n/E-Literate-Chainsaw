package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.world.EntityList;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WitherSkullEntity.class)
public class WitherSkullProjectileMixin extends ExplosiveProjectileEntity {
    protected WitherSkullProjectileMixin(EntityType<? extends WitherSkullEntity> entityType, World world) {
        super(entityType, world);
    }
    //Entity entity = EntityType.COMMAND_BLOCK_MINECART

    @ModifyVariable(
            method = "onCollision",
            at = @At(value = "INVOKE"),
            index = 2
    )
    private Explosion.DestructionType destructionType(Explosion.DestructionType destructionType){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.WITHER_SKULL_ENTITY_GRIEFING))
            return Explosion.DestructionType.NONE;
        return destructionType;
    }
}

