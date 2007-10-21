/* $RCSfile$
 * $Author$ 
 * $Date$
 * $Revision$
 * 
 * Copyright (C) 2003-2007  The Chemistry Development Kit (CDK) project
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *  */
package org.openscience.cdk.tools.manipulator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IChemModel;
import org.openscience.cdk.interfaces.IChemSequence;

/**
 * Class with convenience methods that provide methods from
 * methods from ChemObjects within the ChemSequence.
 *
 * @see org.openscience.cdk.AtomContainer#removeAtomAndConnectedElectronContainers(IAtom)
 *
 * @cdk.module standard
 * @cdk.svnrev  $Revision$
 */
public class ChemSequenceManipulator {

	/**
	 * Get the total number of atoms inside an IChemSequence.
	 * 
	 * @param sequence   The IChemSequence object.
	 * @return           The number of Atom objects inside.
	 */
    public static int getAtomCount(IChemSequence sequence) {
    	int count = 0;
        for (int i=0; i<sequence.getChemModelCount(); i++) {
        	count += ChemModelManipulator.getAtomCount(sequence.getChemModel(i));
        }
        return count;
    }

    /**
	 * Get the total number of bonds inside an IChemSequence.
	 * 
	 * @param sequence   The IChemSequence object.
	 * @return           The number of Bond objects inside.
	 */
    public static int getBondCount(IChemSequence sequence) {
    	int count = 0;
        for (int i=0; i<sequence.getChemModelCount(); i++) {
        	count += ChemModelManipulator.getBondCount(sequence.getChemModel(i));
        }
        return count;
    }

    /**
     * Returns all the AtomContainer's of a ChemSequence.
     */
    public static List getAllAtomContainers(IChemSequence sequence) {
        Iterator models = sequence.chemModels();
        List acList = new ArrayList();
        while (models.hasNext()) {
    		IChemModel chemmodel = (IChemModel)models.next();
            acList.addAll(ChemModelManipulator.getAllAtomContainers(chemmodel));
        }
        return acList;
    }

    /**
     * Returns a List of all IChemObject inside a ChemSequence.
     *
     * @return  A List of all ChemObjects.
     */
	public static List getAllChemObjects(IChemSequence sequence) {
		ArrayList list = new ArrayList();
        // list.add(sequence);
        for (int i=0; i<sequence.getChemModelCount(); i++) {
        	list.add(sequence.getChemModel(i));
        	List current = ChemModelManipulator.getAllChemObjects(sequence.getChemModel(i));
            for (Iterator iter = current.iterator(); iter.hasNext();) {
            	Object o = iter.next();
            	if (!list.contains(o)) list.add(o);
            }
            
        }
		return list;
	}

	public static List getAllIDs(IChemSequence sequence) {
		ArrayList list = new ArrayList();
		if (sequence.getID() != null) list.add(sequence.getID());
        for (int i=0; i<sequence.getChemModelCount(); i++) {
        	list.addAll(ChemModelManipulator.getAllIDs(sequence.getChemModel(i)));
        }
		return list;
	}
}

