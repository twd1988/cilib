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
package net.sourceforge.cilib.util.selection;

import java.util.List;
import net.sourceforge.cilib.util.selection.ordering.Ordering;
import net.sourceforge.cilib.util.selection.weighing.Weighing;

/**
 * @author Wiehann Matthysen
 * @param <E>
 */
public interface SelectionSyntax<E> {

    public SelectionSyntax<E> orderBy(Ordering<E> ordering);

    public SelectionSyntax<E> weigh(Weighing<E> weighing);

    public SelectionSyntax<E> first();

    public SelectionSyntax<E> first(int number);

    public SelectionSyntax<E> last();

    public SelectionSyntax<E> last(int number);

    public SelectionSyntax<E> exclude(List<? extends E> exclusion);

    public List<E> select();

    public List<Selection.Entry<E>> entries();

    public E singleSelect();
}
