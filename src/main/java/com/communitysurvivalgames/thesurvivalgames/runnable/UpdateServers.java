package com.communitysurvivalgames.thesurvivalgames.runnable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.md_5.bungee.api.config.ServerInfo;

import com.communitysurvivalgames.thesurvivalgames.server.SGServerList;

public class UpdateServers implements Runnable {

	@Override
	public void run() {
		for (ServerInfo sinfo : SGServerList.getServerList().getList().keySet()) {
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(bytes);
			try {
				out.writeUTF(sinfo.getName());
				out.writeUTF( SGServerList.getServerList().getServerStatus(sinfo).toString());
				out.writeInt(sinfo.getPlayers().size());
			} catch (IOException e) {
				continue;
			}
			
			sinfo.sendData("SGUpdate", bytes.toByteArray());
		}
	}
}
