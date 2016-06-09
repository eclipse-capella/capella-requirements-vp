/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction;
import org.eclipse.emf.diffmerge.bridge.util.structures.AbstractPureStructure;
import org.eclipse.emf.diffmerge.bridge.util.structures.ITuple;
import org.eclipse.emf.diffmerge.bridge.util.structures.Tuple2;
import org.eclipse.emf.diffmerge.bridge.util.structures.Tuples;

/**
 * @author Joao Barata
 */
public class TupleNP<E> extends AbstractPureStructure<E> implements ITuple<E> {
  
  /** The non-null, non-modifiable list of elements of the Tuple */
  protected final E _rootElement;
  /** The non-null, non-modifiable list of elements of the Tuple */
  protected final Map<String, E> _elements;
  
  
  /**
   * Constructor
   * @param elements the non-null, non-empty list of non-null elements of the tuple
   * Duplicates are permitted.
   */
  public TupleNP(E root, Map<String, E> elements) {
	_rootElement = root;
    _elements = elements;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.util.structures.IPureStructure#asCollection()
   */
  public List<E> asCollection() {
    return new ArrayList<E>(_elements.values());
  }
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean result = false;
    if (object instanceof ITuple<?>) {
      ITuple<?> peer = (ITuple<?>)object;
      
      result = asCollection().containsAll(peer.asCollection()) && peer.asCollection().containsAll(asCollection());
      //result = asCollection().equals(peer.asCollection());
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.bridge.util.structures.ITuple#get(int)
   */
  public E get(int index) {
    throw new UnsupportedOperationException();
  }

  /**
   * @see org.eclipse.emf.diffmerge.bridge.util.structures.ITuple#get(int)
   */
  public E get(String key) {
    return _elements.get(key);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.util.structures.ITuple#get(int)
   */
  public E getRoot() {
    return _rootElement;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.util.structures.IPureStructure#getContents()
   */
  public Collection<Tuple2<String, E>> getContents() {
    List<Tuple2<String, E>> result = new ArrayList<Tuple2<String, E>>(_elements.size());
//    int i = 1;
    for (Map.Entry<String, E> entry : _elements.entrySet()) {
      result.add(Tuples.tuple(entry.getKey(), entry.getValue()));
    }
//    for (E element : _elements) {
//      result.add(Tuples.tuple(Integer.valueOf(i), element));
//      i++;
//    }
    return Collections.unmodifiableCollection(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.ISymbolProvider#getSymbol(org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction)
   */
  public Object getSymbol(ISymbolFunction function) {
    StringBuilder builder = new StringBuilder();
    builder.append('(');
    boolean first = true;

    for (Map.Entry<String, E> entry : _elements.entrySet()) {
      if (first) {
        first = false;
      } else {
        builder.append(',');
        builder.append(' ');
      }
      Object elementSymbol = function.getSymbol(entry.getValue());
      builder.append(elementSymbol); // Might be null if function is not appropriate
    }
//    for (E element : _elements) {
//      if (first) {
//        first = false;
//      } else {
//        builder.append(',');
//        builder.append(' ');
//      }
//      Object elementSymbol = function.getSymbol(element);
//      builder.append(elementSymbol); // Might be null if function is not appropriate
//    }
    builder.append(')');
    return builder.toString();
  }
  
  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
	  return Objects.hash(_elements.values().toArray());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.util.structures.AbstractPureStructure#size()
   */
  @Override
  public int size() {
    return _elements.size();
  }
  
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + asCollection().toString();
  }
  
}
