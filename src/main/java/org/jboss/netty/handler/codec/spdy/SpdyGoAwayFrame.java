/*
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.netty.handler.codec.spdy;

/**
 * A SPDY Protocol GOAWAY Control Frame
 */
public interface SpdyGoAwayFrame {

    /**
     * Returns the Last-good-stream-ID of this frame.
     */
    int getLastGoodStreamID();

    /**
     * Sets the Last-good-stream-ID of this frame.  The Last-good-stream-ID
     * cannot be negative.
     */
    void setLastGoodStreamID(int lastGoodStreamID);
}
