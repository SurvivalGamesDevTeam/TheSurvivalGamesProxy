package com.communitysurvivalgames.thesurvivalgames;

import java.util.concurrent.TimeUnit;

import com.communitysurvivalgames.thesurvivalgames.listener.SGJoinListener;
import com.communitysurvivalgames.thesurvivalgames.runnable.UpdateServers;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class TheSurvivalGamesProxy extends Plugin {
	@Override
	public void onEnable() {
		ProxyServer.getInstance().registerChannel("SGUpdate");
		ProxyServer.getInstance().registerChannel("SGJoin");
		
		ProxyServer.getInstance().getPluginManager().registerListener(this, new SGJoinListener());
		
		ProxyServer.getInstance().getScheduler().schedule(this, new UpdateServers(), 5, 5, TimeUnit.SECONDS);
	}

	@Override
	public void onDisable() {

	}
}