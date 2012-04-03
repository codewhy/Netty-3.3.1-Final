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
 * A SPDY Protocol SYN_STREAM Control Frame
 */
public interface SpdySynStreamFrame extends SpdyHeaderBlock {

    /**
     * Returns the Stream-ID of this frame.
     */
    int getStreamID();

    /**
     * Sets the Stream-ID of this frame.  The Stream-ID must be positive.
     */
    void setStreamID(int streamID);

    /**
     * Returns the Associated-To-Stream-ID of this frame.
     */
    int getAssociatedToStreamID();

    /**
     * Sets the Associated-To-Stream-ID of this frame.
     * The Associated-To-Stream-ID cannot be negative.
     */
    void setAssociatedToStreamID(int associatedToStreamID);

    /**
     * Returns the priority of the stream.
     */
    byte getPriority();

    /**
     * Sets the priority of the stream.
     * The priority must be between 0 and 3 inclusive.
     */
    void setPriority(byte priority);

    /**
     * Returns {@code true} if this frame is the last frame to be transmitted
     * on the stream.
     */
    boolean isLast();

    /**
     * Sets if this frame is the last frame to be transmitted on the stream.
     */
    void setLast(boolean last);

    /**
     * Returns {@code true} if the stream created with this frame is to be
     * considered half-closed to the receiver.
     */
    boolean isUnidirectional();

    /**
     * Sets if the stream created with this frame is to be considered
     * half-closed to the receiver.
     */
    void setUnidirectional(boolean unidirectional);
}
