/**
 * Copyright (C) 2003 - 2009
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
 */
package net.sourceforge.cilib.nn.components;

import net.sourceforge.cilib.io.pattern.StandardPattern;
import net.sourceforge.cilib.nn.architecture.NeuralInputSource;
import net.sourceforge.cilib.type.types.Type;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 * Class represents a {@link NeuralInputSource} that decorates a {@link StandardPattern}
 * such that the pattern can be used as an input source for a neuron.
 * @author andrich
 */
public class PatternInputSource implements NeuralInputSource {

    private StandardPattern pattern;
    private Vector inputVector;

    /**
     * Constructor taking the {@link StandardPattern} to decorate as argument.
     * @param pattern the pattern to decorate.
     */
    public PatternInputSource(StandardPattern pattern) {
        this.pattern = pattern;
        this.inputVector = pattern.getVector();
    }

    /**
     * Gets the neural input by indexing into the decorated pattern's input vector.
     * @param index the index of the input to retreive.
     * @return
     */
    @Override
    public double getNeuralInput(int index) {
        return inputVector.getReal(index);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int size() {
        return pattern.getVector().size();
    }

    /**
     * Gets the pattern's input vector.
     * @return the input vector of the pattern.
     */
    public Vector getVector() {
        return inputVector;
    }

    /**
     * Gets the pattern's target.
     * @return the target of the pattern.
     */
    public Type getTarget() {
        return pattern.getTarget();
    }
}