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
	ENDERDRAGON_MOB_GRIEFING = register("enderdragon_mob_griefing"),
	ENDERMAN_BLOCK_GRIEFING = register("enderman_mob_griefing"),
	ZOMBIE_MOB_GRIEFING = register("zomie_mob_griefing"),
	DROWNED_MOB_GRIEFING = register("water_zomie"),
	ZOMBIFIED_PIGLIN_MOB_GRIEFING = register("zombified_piglin_mob_griefing"),
	HUSK_MOB_GRIEFING = register("husk_mob_griefing"),
	ZOMBIE_VILLAGER_MOB_GRIEFING = register("zombie_villager_mob_griefing"),
	SKELENTON_MOB_GRIEFING = register("skelenton_mob_griefing"),
	STRAY_MOB_GRIEFING = register("stray_mob_griefing"),
	GHAST_MOB_GRIEFING = register("ghast_mob_griefing"),
	BLAZE_MOB_GRIEFING = register("blaze_mob_grieifing"),
	VILLAGER_MOB_GRIEFING = register("villager_mob_grieifng"),
	SHEEP_MOB_GRIEFING = register("sheep_mob_griefing"),
	EVOKER_MOB_GRIEFING = register("evoker_mob_griefing"),
	RAVAGER_MOB_GRIEFING = register("raver_mob_griefing"),
	SNOW_GOLEM_MOB_GRIEFING = register("snow_golem_mob_griefing"),
	HOSTILE_MOB_ITEMPICKUP = register("hostile_mob_item_pickup"),
	PASSIVE_MOB_ITEM_PICKUP = register("passive_mob_item_pickup"),
	PIGLIN_ITEM_PICKUP = register("piglin_item_pickup");

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
