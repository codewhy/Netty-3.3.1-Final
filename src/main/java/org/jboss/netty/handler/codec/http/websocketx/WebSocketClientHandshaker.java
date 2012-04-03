/*
 * Copyright 2011 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.handler.codec.http.websocketx;

import java.net.URI;
import java.util.Map;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.handler.codec.http.HttpResponse;

/**
 * Base class for web socket client handshake implementations
 */
public abstract class WebSocketClientHandshaker {

    private final URI webSocketUrl;

    private final WebSocketVersion version;

    private boolean handshakeComplete;

    private final String expectedSubprotocol;

    private String actualSubprotocol;

    protected final Map<String, String> customHeaders;

    /**
     * Base constructor
     *
     * @param webSocketUrl
     *            URL for web socket communications. e.g "ws://myhost.com/mypath". Subsequent web socket frames will be
     *            sent to this URL.
     * @param version
     *            Version of web socket specification to use to connect to the server
     * @param subprotocol
     *            Sub protocol request sent to the server.
     * @param customHeaders
     *            Map of custom headers to add to the client request
     */
    public WebSocketClientHandshaker(URI webSocketUrl, WebSocketVersion version, String subprotocol,
            Map<String, String> customHeaders) {
        this.webSocketUrl = webSocketUrl;
        this.version = version;
        expectedSubprotocol = subprotocol;
        this.customHeaders = customHeaders;
    }

    /**
     * Returns the URI to the web socket. e.g. "ws://myhost.com/path"
     */
    public URI getWebSocketUrl() {
        return webSocketUrl;
    }

    /**
     * Version of the web socket specification that is being used
     */
    public WebSocketVersion getVersion() {
        return version;
    }

    /**
     * Flag to indicate if the opening handshake is complete
     */
    public boolean isHandshakeComplete() {
        return handshakeComplete;
    }

    protected void setHandshakeComplete() {
        handshakeComplete = true;
    }

    /**
     * Returns the sub protocol request sent to the server as specified in the constructor
     */
    public String getExpectedSubprotocol() {
        return expectedSubprotocol;
    }

    /**
     * Returns the sub protocol response and sent by the server. Only available after end of handshake.
     */
    public String getActualSubprotocol() {
        return actualSubprotocol;
    }

    protected void setActualSubprotocol(String actualSubprotocol) {
        this.actualSubprotocol = actualSubprotocol;
    }

    /**
     * Begins the opening handshake
     * 
     * @param channel
     *            Channel
     */
    public abstract ChannelFuture handshake(Channel channel);

    /**
     * Validates and finishes the opening handshake initiated by {@link #handshake}}.
     * 
     * @param channel
     *            Channel
     * @param response
     *            HTTP response containing the closing handshake details
     */
    public abstract void finishHandshake(Channel channel, HttpResponse response);
}
