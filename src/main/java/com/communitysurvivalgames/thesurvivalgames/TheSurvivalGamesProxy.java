package com.communitysurvivalgames.thesurvivalgames;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class TheSurvivalGamesProxy extends Plugin {
	@Override
	public void onEnable() {
		ProxyServer.getInstance().registerChannel("SG");
		ProxyServer.getInstance().getPluginManager().
	}

	@Override
	public void onDisable() {

	}
}