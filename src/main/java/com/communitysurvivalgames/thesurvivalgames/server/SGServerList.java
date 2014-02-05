package com.communitysurvivalgames.thesurvivalgames.server;

import java.util.HashMap;
import java.util.Map;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

public class SGServerList {
	private static SGServerList sgServerList = new SGServerList();
	private Map<ServerInfo, ServerStatus> servers = new HashMap<ServerInfo, ServerStatus>();
	private ServerInfo hubServer;

	public static SGServerList getServerList() {
		return sgServerList;
	}

	public void registerServers() {
		Map<String, ServerInfo> serverList = ProxyServer.getInstance().getServers();
		for (ServerInfo sinfo : serverList.values()) {
			if (sinfo.getName().startsWith("sg_")) {
				servers.put(sinfo, ServerStatus.OFFLINE);
			}

			if (sinfo.getName().startsWith("hub_")) {
				hubServer = sinfo;
			}
		}
	}

	public Map<ServerInfo, ServerStatus> getList() {
		return servers;
	}

	public ServerStatus getServerStatus(String serverName) {
		return servers.get(ProxyServer.getInstance().getServers().get(serverName));
	}
	
	public ServerStatus getServerStatus(ServerInfo sinfo) {
		return servers.get(sinfo);

	}

	public void reportServerStatus(String serverName, ServerStatus stat) {

	}

	public ServerInfo getHubServer() {
		return hubServer;
	}
}
