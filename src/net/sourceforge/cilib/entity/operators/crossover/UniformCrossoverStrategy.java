/*
 * UniformCrossoverStrategy.java
 * 
 * Created on Apr 1, 2006
 *
 * Copyright (C) 2003, 2004 - CIRG@UP 
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
package net.sourceforge.cilib.entity.operators.crossover;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.cilib.algorithm.Algorithm;
import net.sourceforge.cilib.algorithm.PopulationBasedAlgorithm;
import net.sourceforge.cilib.entity.Entity;
import net.sourceforge.cilib.problem.OptimisationProblem;
import net.sourceforge.cilib.type.types.Vector;

/**
*
* @author  Andries Engelbrecht
*/

public class UniformCrossoverStrategy extends CrossoverStrategy {
	
	public UniformCrossoverStrategy() {
		super();
	}
	
	public UniformCrossoverStrategy(UniformCrossoverStrategy copy) {
		super(copy);
	}
	
	public UniformCrossoverStrategy clone() {
		return new UniformCrossoverStrategy(this);
	}

	@Override
	public List<Entity> crossover(List<? extends Entity> parentCollection) {
		List<Entity> offspring = new ArrayList<Entity>(parentCollection.size());
		
		for (int entity = 0; entity < parentCollection.size(); entity++) {
			int random1 = this.getRandomNumber().getRandomGenerator().nextInt(parentCollection.size());
			int random2 = this.getRandomNumber().getRandomGenerator().nextInt(parentCollection.size());
			
			//How do we handle variable sizes? Resizing the entities?
			Entity offspring1 = parentCollection.get(random1).clone();
			Entity offspring2 = parentCollection.get(random2).clone();
			
			if (this.getCrossoverProbability().getParameter() >= this.getRandomNumber().getUniform()) {
				
				Vector parentChromosome1 = (Vector) parentCollection.get(random1).get();
				Vector parentChromosome2 = (Vector) parentCollection.get(random2).get();
				Vector offspringChromosome1 = (Vector) offspring1.get();
				Vector offspringChromosome2 = (Vector) offspring2.get();
				
				int sizeParent1 = parentChromosome1.getDimension();
				int sizeParent2 = parentChromosome2.getDimension();
			
				int minDimension = Math.min(sizeParent1, sizeParent2);
										
				for (int i = 0; i < minDimension; i++) {
					if (i%2 == 0) {
						offspringChromosome1.set(i,parentChromosome1.get(i));
						offspringChromosome2.set(i,parentChromosome2.get(i));
					}
					else {
						offspringChromosome1.set(i,parentChromosome2.get(i));
						offspringChromosome2.set(i,parentChromosome1.get(i));	
					}
				}
			}
			
			OptimisationProblem problem = ((PopulationBasedAlgorithm) Algorithm.get()).getOptimisationProblem();
			offspring1.setFitness(problem.getFitness(offspring1.get(), false));
			offspring2.setFitness(problem.getFitness(offspring2.get(), false));
			
			offspring.add(offspring1);
			offspring.add(offspring2);
		}
		
		return offspring;
	}
	

}
