package org.synku4j.activesync.client;

import java.net.URL;

import org.testng.annotations.Test;

public class ActiveSyncClientTest {
	

	@Test
	public void testFolderSync() throws Exception {
		final URL serverURL = new URL("https://m.google.com/Microsoft-Server-ActiveSync");
		ActiveSyncClientContext cntx = new ActiveSyncClientContext();
		ActiveSyncClient client = new ActiveSyncClient("zynkusync","badger9999", serverURL, cntx);
		
		System.out.println("Server version = "+client.getServerVersion());
		System.out.println("Server protocol versions = "+client.getServerVersion());
		System.out.println("Server protocol commands = "+client.getServerCommands());
	}
}

