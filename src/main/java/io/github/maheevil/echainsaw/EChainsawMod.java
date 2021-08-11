package io.github.maheevil.echainsaw;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class EChainsawMod implements ModInitializer {

	public static final GameRules.Key<GameRules.BooleanRule>
	ENDERDRAGON_MOB_GRIEFING = register("enderdragon_mob_griefing"),
	ENDERMAN_BLOCK_GRIEFING = register("enderman_mob_griefing"),
	PASSIVE_MOB_GRIEFING = register("passive_mob_griefing"),
	//SHEEP_MOB_GRIEFING = register("sheep_mob_griefing"),
	//SNOW_GOLEM_MOB_GRIEFING = register("snow_golem_mob_griefing"),
	MOB_ENTITY_COLLISION_BlOCK_GRIEFING = register("mob_entity_collision_block_griefing"),
	MOB_DOOR_BREAKING = register("zombie_door_breaking"),
	HOSTILE_MOB_BLOCK_DAMAGE = register("hostile_mob_block_damage"),
	MOB_CROP_HARVEST = register("mob_crop_harvest"),
	WITHER_MOB_DAMAGE = register("wither_mob_damage"),
	CREEPER_MOB_GIREFING = register("creeper_mob_griefing"),
	HOSTILE_MOB_ITEMPICKUP = register("hostile_mob_item_pickup"),
	//PASSIVE_MOB_ITEM_PICKUP = register("passive_mob_item_pickup"),
	UNDEAD_MOBS_TURTLE_EGG_GRIEFING = register("undead_mob_turtle_egg_griefing"),
	MISC_MOB_GRIEFING = register("misc_mob_griefing"),
	PIGLIN_ITEM_PICKUP = register("piglin_item_pickup");

	private static GameRules.Key<GameRules.BooleanRule> register(String id) {
		return GameRuleRegistry.register(id, GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	}


	public void onInitialize() {

	}
}
