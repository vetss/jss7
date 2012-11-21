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

package org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation;

/**
*
GeographicalInformation ::= OCTET STRING (SIZE (8))
--	Refers to geographical Information defined in 3GPP TS 23.032.
--	Only the description of an ellipsoid point with uncertainty circle
--	as specified in 3GPP TS 23.032 is allowed to be used
--	The internal structure according to 3GPP TS 23.032 is as follows:
--		Type of shape (ellipsoid point with uncertainty circle)	1 octet
--		Degrees of Latitude				3 octets
--		Degrees of Longitude				3 octets
--		Uncertainty code				1 octet
* 
* @author sergey vetyutnev
* 
*/
public interface GeographicalInformation {

	public byte[] getData();

	public TypeOfShape getTypeOfShape();

	/**
	 * @return Latitude value in degrees (-90 ... 90)
	 */
	public double getLatitude();

	/**
	 * @return Longitude value in degrees (-180 ... 180)
	 */
	public double getLongitude();

	/**
	 * @return Uncertainty value in meters
	 */
	public double getUncertainty();

}

