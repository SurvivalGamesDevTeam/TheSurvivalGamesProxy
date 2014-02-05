package com.communitysurvivalgames.thesurvivalgames.listener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.SQLException;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import com.communitysurvivalgames.thesurvivalgames.server.SGServerList;
import com.communitysurvivalgames.thesurvivalgames.server.ServerStatus;

/**
 * Format:
 * 
 * Tag: SGJoin
 * Data1: Arena Name (As server name)
 * Data2: Player to be sent to arena
 * 
 */
public class SGJoinListener implements Listener {

	@EventHandler
	public void receivePluginMessage(PluginMessageEvent event) throws IOException, SQLException {
		if (event.isCancelled()) {
			return;
		}
		if (!(event.getSender() instanceof Server))
			return;
		if (!event.getTag().equalsIgnoreCase("SGJoin")) {
			return;
		}
		event.setCancelled(true);

		DataInputStream in = new DataInputStream(new ByteArrayInputStream(event.getData()));
		String arena = in.readUTF();

		ServerStatus status = SGServerList.getServerList().getServerStatus(arena);
		if (status == null) {
			return;
		}

		if (status == ServerStatus.WAITING_FOR_PLAYERS) {
			ProxyServer.getInstance().getPlayer(in.readUTF()).connect(ProxyServer.getInstance().getServerInfo(arena));
		}
	}
}
