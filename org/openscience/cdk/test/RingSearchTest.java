/* RingSearchTest.java
 * 
 * $RCSfile$    $Author$    $Date$    $Revision$
 * 
 * Copyright (C) 1997-2001  The Chemistry Development Kit (CDK) project
 * 
 * Contact: steinbeck@ice.mpg.de, geelter@maul.chem.nd.edu, egonw@sci.kun.nl
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA. 
 */

package org.openscience.cdk.test;


import org.openscience.cdk.*;
import org.openscience.cdk.ringsearch.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.tools.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import junit.framework.*;

public class RingSearchTest extends TestCase
{
	Molecule molecule;
	SSSRFinder sssrf;
	RingSet ringSet;
	
	public RingSearchTest(String name)
	{
		super(name);
	}

	public void setUp()
	{
		sssrf = new SSSRFinder();
		molecule = MoleculeFactory.makeAlphaPinene();
	}

	public static Test suite() {
		return new TestSuite(RingSearchTest.class);
	}

	public void testAlphaPinene()
	{
		ringSet = sssrf.findSSSR(molecule);
		assertTrue(ringSet.size() == 2);
	}
	
}

