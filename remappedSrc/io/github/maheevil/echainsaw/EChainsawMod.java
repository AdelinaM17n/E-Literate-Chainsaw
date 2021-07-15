package io.github.maheevil.echainsaw;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class EChainsawMod implements ModInitializer {
	//public static boolean hj;
	//public int h = 1;
	//@Override
	public static final GameRules.Key<GameRules.BooleanRule>
	CREEPER_GRIEFING = register("creeper"),
	WITHER_SKULL_ENTITY_GRIEFING = register("wither_skull_entity"),
	WITHER_COLLISION_GRIEFING = register("wither_collision_griefing"),
	WITHER_INITIAL_EXPLOSION_GRIEFING = register("wither_initial_explosion_griefing"),
	ENDERDRAGON_MOB_GRIEFING = register("enderdragon_mob_griefing");



	private static GameRules.Key<GameRules.BooleanRule> register(String id) {
		return GameRuleRegistry.register(id, GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	}




	public void onInitialize() {

		/*System.out.println("Hello Fabric world!");
		String h = new Scanner(System.in).nextLine();
		if(h.equalsIgnoreCase("h")){
			this.h = 3;
			hj=true;
		}
		System.out.println(this.h);*/

	}
}
