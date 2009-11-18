package org.synku4j.activesync.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

import com.zynku.sync.activesync.context.ActiveSyncContext;
import com.zynku.sync.activesync.control.ActiveSyncController;
import com.zynku.sync.activesync.model.ActiveSyncApplicationData;

/**
 * The <code>ActiveSyncClient</code> is the client class used to access an
 * active sync server and obtain information regarding that server.

 * @author Jools Enticknap
 */
public class ActiveSyncClient {

	private final String userName;
	private final String password;
	private final URL serverURL;
	private final ActiveSyncClientContext cntx;
	private final ActiveSyncContext acntx = new ActiveSyncContext();
	private final ActiveSyncController asController;
	
	public ActiveSyncClient(final String userName, final String password, final URL serverURL, final ActiveSyncClientContext cntx)
	throws HttpException, IOException 
	{
		this.userName = userName;
		this.password = password;
		this.serverURL = serverURL;
		this.cntx = cntx;
		
		acntx.setDeviceId("Appl9C808MH40JW");
		acntx.setUserName(userName);
		acntx.setPassword(password);

		acntx.setDeviceId("Appl9C808MH40JW");
		acntx.setDeviceType("iPod");
		acntx.setServerURL(serverURL);
		
		asController = new ActiveSyncController(acntx);
		
	}
	
	public List<ActiveSyncApplicationData> getContacts() throws HttpException, IOException {
		return asController.getContacts();
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

}
