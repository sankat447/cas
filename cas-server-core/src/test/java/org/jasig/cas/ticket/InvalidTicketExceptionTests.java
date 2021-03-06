/*
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.ticket;

import static org.junit.Assert.*;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.BadCredentialsAuthenticationException;
import org.junit.Test;

/**
 * @author Misagh Moayyed
 * @since 3.0.0
 */
public class InvalidTicketExceptionTests {

    @Test
    public void verifyCodeNoThrowable() {
        final TicketException t = new InvalidTicketException("InvalidTicketId");
        assertEquals("INVALID_TICKET", t.getCode());
    }

    @Test
    public void verifyCodeWithThrowable() {
        final AuthenticationException a = new BadCredentialsAuthenticationException();
        final TicketException t = new InvalidTicketException(a, "InvalidTicketId");

        assertEquals(a.toString(), t.getCode());
    }
}
