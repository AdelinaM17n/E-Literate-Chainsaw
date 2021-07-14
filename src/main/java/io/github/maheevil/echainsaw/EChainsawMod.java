package io.github.maheevil.echainsaw;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Scanner;

public class EChainsawMod implements ModInitializer {
	//public static boolean hj;
	//public int h = 1;
	//@Override
	public static final GameRules.Key<GameRules.BooleanRule>
	CREEPER_GRIEFING = register("creeper");


	private static GameRules.Key<GameRules.BooleanRule> register(String creeper) {
		return GameRuleRegistry.register(creeper, GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
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
