/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.tools.traceparser;

import java.io.IOException;

import org.mobicents.protocols.ss7.sccp.SccpListener;
import org.mobicents.protocols.ss7.sccp.SccpProvider;
import org.mobicents.protocols.ss7.sccp.impl.message.MessageFactoryImpl;
import org.mobicents.protocols.ss7.sccp.impl.parameter.ParameterFactoryImpl;
import org.mobicents.protocols.ss7.sccp.message.MessageFactory;
import org.mobicents.protocols.ss7.sccp.message.SccpMessage;
import org.mobicents.protocols.ss7.sccp.parameter.ParameterFactory;


/**
 * 
 * @author sergey vetyutnev
 * 
 */
public class SccpProviderWrapper implements SccpProvider {

	@Override
	public MessageFactory getMessageFactory() {
		return new MessageFactoryImpl();
	}

	@Override
	public ParameterFactory getParameterFactory() {
		return new ParameterFactoryImpl();
	}

	@Override
	public void registerSccpListener(int ssn, SccpListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deregisterSccpListener(int ssn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(SccpMessage message, int seqControl) throws IOException {
		// TODO Auto-generated method stub

	}

}
