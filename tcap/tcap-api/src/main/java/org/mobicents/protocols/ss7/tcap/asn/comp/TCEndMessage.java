/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
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

package org.mobicents.protocols.ss7.tcap.asn.comp;

import org.mobicents.protocols.asn.Tag;
import org.mobicents.protocols.ss7.tcap.asn.DialogPortion;
import org.mobicents.protocols.ss7.tcap.asn.Encodable;

/**
 * @author baranowb
 *
 */
public interface TCEndMessage extends Encodable {
	public static final int _TAG = 0x04;
	public static final boolean _TAG_PC_PRIMITIVE = false;
	public static final int _TAG_CLASS = Tag.CLASS_APPLICATION;
	
	public static final int _TAG_DTX = 0x09;
	public static final boolean _TAG_DTX_PC_PRIMITIVE = true;
	public static final int _TAG_CLASS_DTX = Tag.CLASS_APPLICATION;
	
	
	//mandatory
	public byte[] getDestinationTransactionId();
	public void setDestinationTransactionId(byte[] t);
	
	//opt FIXME: make this External?
	public DialogPortion getDialogPortion();
	public void setDialogPortion(DialogPortion dp);
	//opt
	public Component[] getComponent();
	public void setComponent(Component[] c);
	
	
}
