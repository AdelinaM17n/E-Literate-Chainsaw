package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreeperEntity.class)
public class CreeperMixin extends HostileEntity {
	//private Explosion.DestructionType destructionType;
	//@Shadow Explosion.DestructionType destructionType;


	//@Inject(at = @At("HEAD"), method = "explode")
	//public void explode(CallbackInfo ci){
		//return;
	//}
	//@Shadow World world;

	protected CreeperMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@ModifyVariable(
		method = "explode",
			at = @At(value = "STORE"),
			index = 1
	)
	private Explosion.DestructionType destructionType(Explosion.DestructionType destructionType){
		if(!this.world.getGameRules().getBoolean(EChainsawMod.CREEPER_MOB_GIREFING))
			return Explosion.DestructionType.NONE;
		return destructionType;
	}

}