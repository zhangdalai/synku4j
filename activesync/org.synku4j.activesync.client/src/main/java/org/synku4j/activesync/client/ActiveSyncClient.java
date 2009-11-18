package org.synku4j.activesync.client;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.OptionsMethod;

/**
 * The <code>ActiveSyncClient</code> is the client class used to access an
 * active sync server and obtain information regarding that server.

 * @author Jools Enticknap
 */
public class ActiveSyncClient {

	private static final String MS_SERVER_HDR = "MS-Server-ActiveSync";
	private static final String MS_PROTOCOL_VERSIONS_HDR = "MS-ASProtocolVersions";
	private static final String MS_PROTOCOL_COMMANDS_HDR = "MS-ASProtocolCommands";
	
	private final String userName;
	private final String password;
	private final URL serverURL;
	private final ActiveSyncClientContext cntx;
	private final HttpClient httpClient = new HttpClient();
	
	private String serverVersion;
	private List<String> serverCommands;
	private List<String> protocolVersions;
	
	public ActiveSyncClient(final String userName, final String password, final URL serverURL, final ActiveSyncClientContext cntx)
	throws HttpException, IOException 
	{
		this.userName = userName;
		this.password = password;
		this.serverURL = serverURL;
		
		if (cntx == null) {
			this.cntx = new ActiveSyncClientContext();
		} else {
			this.cntx = cntx;
		}

		init();
	}

	private void init() throws HttpException, IOException {
		final OptionsMethod method = new OptionsMethod(serverURL.toExternalForm());
		int result = httpClient.executeMethod(method);
		
		if (result != 200) {
			throw new HttpException("Option request to server resulted in ("+result+") expected 200");
		}
		
		serverVersion = method.getResponseHeader(MS_SERVER_HDR).getValue();
		
		final String cmds =  method.getResponseHeader(MS_PROTOCOL_COMMANDS_HDR).getValue();
		serverCommands = Arrays.asList(cmds.split(","));
		
		final String versions = method.getResponseHeader(MS_PROTOCOL_VERSIONS_HDR).getValue();
		protocolVersions = Arrays.asList(versions.split(","));
		
		method.releaseConnection();
	}

	public void syncFolders() {

	}
	

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public URL getServerURL() {
		return serverURL;
	}

	public ActiveSyncClientContext getCntx() {
		return cntx;
	}

	public List<String> getServerCommands() {
		return serverCommands;
	}

	public List<String> getProtocolVersions() {
		return protocolVersions;
	}
}
