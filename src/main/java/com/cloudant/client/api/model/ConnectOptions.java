package com.cloudant.client.api.model;
/**
 * Represents optional configuration properties for connecting to CloudantDB.
 * @author Ganesh K Choudhary
 */
public class ConnectOptions {

	private int socketTimeout;
	private int connectionTimeout ;
	private int connectionRequestTimeout;
	private int maxConnections ;
	
	private String proxyHost ;
	private int proxyPort ;
	
	public ConnectOptions(){
		// default constructor
	}

	public ConnectOptions setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
		return this ;
	}

	public ConnectOptions setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this ;
	}

	/**
	 * Sets the connection request timeout.
	 * It determines how long to wait to get a connection request from a
	 * connection request pool.
	 * @param connectionRequestTimeout the desired timeout
	 * @return the updated {@link ConnectOptions} object.
	 * @see #getConnectionRequestTimeout()
	 */
	public ConnectOptions setConnectionRequestTimeout(int connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
		return this;
	}

	public ConnectOptions setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
		return this ;
	}

	public ConnectOptions setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
		return this ;
	}

	public ConnectOptions setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
		return this ;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * Returns the connection request timeout.
	 * It determines how long to wait to get a connection request from a
	 * connection request pool.
	 * @see #setConnectionRequestTimeout(int)
	 */
	public int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}
	
	
	
	
}
