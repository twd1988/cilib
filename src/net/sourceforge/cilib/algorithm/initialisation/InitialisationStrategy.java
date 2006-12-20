/*
 * InitialisationBuilder.java
 *
 * Created on April 24, 2006, 2:26 PM
 *
 *
 * Copyright (C) 2003 - 2006 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package net.sourceforge.cilib.algorithm.initialisation;

import net.sourceforge.cilib.entity.Entity;
import net.sourceforge.cilib.entity.Topology;
import net.sourceforge.cilib.problem.OptimisationProblem;

/**
 * Interface for the InitialisationBuilder.
 * 
 * @author Gary Pampara
 */
public abstract class InitialisationStrategy {
	
	protected int entities;
	
	public abstract InitialisationStrategy clone();

	/**
	 * Set the number of entities that are required.
	 * 
	 * @param entityNumber The number of entities to set
	 */
	public void setEntities(int entityNumber) {
		this.entities = entityNumber;
	}
	
	
	/**
	 * Set the entity type to use
	 * 
	 * @param entityType The entity type to use
	 */
	public abstract void setEntityType(Entity entity);
	
	
	/**
	 * Get the current entity type
	 * @return The entity being used.
	 */
	public abstract Entity getEntityType();

	
	/**
	 * Initialise the {@see net.sourceforge.cilib.entity.Entity} collection
	 * based on the given Topology and Problem.
	 * 
	 * @param topology The topology to initialise with Entity objects
	 * @param problem The Problem to based the initialisation on
	 */
	public abstract void intialise(Topology<? extends Entity> topology, OptimisationProblem problem);


	public int getEntities() {
		return this.entities; 
	}

}
