/**
 * Computational Intelligence Library (CIlib)
 * Copyright (C) 2003 - 2010
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.cilib.pso.dynamic;

import net.sourceforge.cilib.entity.Particle;
import net.sourceforge.cilib.pso.velocityupdatestrategies.StandardVelocityUpdate;
import net.sourceforge.cilib.pso.velocityupdatestrategies.VelocityUpdateStrategy;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 * Velocity update strategy for QSO (Quantum PSO). Implemented according
 * to paper by Blackwell and Branke, "Multiswarms, Exclusion, and Anti-
 * Convergence in Dynamic Environments."
 *
 * @author Anna Rakitianskaia
 *
 */
public class QuantumVelocityUpdateStrategy implements VelocityUpdateStrategy {

    private static final long serialVersionUID = -940568473388702506L;
    private static final double EPSILON = 0.000000001;
    
    private VelocityUpdateStrategy delegate;

    /**
     * Create a new instance of {@linkplain QuantumPositionUpdateStrategy}.
     */
    public QuantumVelocityUpdateStrategy() {
        this.delegate = new StandardVelocityUpdate();
    }

    /**
     * Create an copy of the provided instance.
     * @param copy The instance to copy.
     */
    public QuantumVelocityUpdateStrategy(QuantumVelocityUpdateStrategy copy) {
        this.delegate = copy.delegate.getClone();
    }

    @Override
    public QuantumVelocityUpdateStrategy getClone() {
        return new QuantumVelocityUpdateStrategy(this);
    }

    /**
     * Update particle velocity; do it in a standard way if the particle is neutral, and
     * do not update it if the particle is quantum (charged), since quantum particles do
     * not use the velocity to update their positions.
     * @param particle the particle to update position of
     */
    @Override
    public Vector get(Particle particle) {
        ChargedParticle checkChargeParticle = (ChargedParticle) particle;
        if (checkChargeParticle.getCharge() < EPSILON) {    // the particle is neutral
            return this.delegate.get(particle);
        }
        return (Vector) particle.getVelocity().getClone();
    }

    @Override
    public void updateControlParameters(Particle particle) {
        this.delegate.updateControlParameters(particle);
    }
}
