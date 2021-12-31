/*
 * glTF JSON model
 * 
 * Do not modify this class. It is automatically generated
 * with JsonModelGen (https://github.com/javagl/JsonModelGen)
 * Copyright (c) 2016 Marco Hutter - http://www.javagl.de
 */

// Copyright 2020. Explore in HMS. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v2;

import java.util.ArrayList;
import java.util.List;


/**
 * A set of primitives to be rendered. A node can contain one mesh. A 
 * node's transform places the mesh in the scene. 
 * 
 * Auto-generated for mesh.schema.json 
 * 
 */
public class Mesh
    extends GlTFChildOfRootProperty
{

    /**
     * An array of primitives, each defining geometry to be rendered with a 
     * material. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;Geometry to be rendered with the given material. 
     * (optional) 
     * 
     */
    private List<MeshPrimitive> primitives;
    /**
     * Array of weights to be applied to the Morph Targets. (optional)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;The elements of this array (optional) 
     * 
     */
    private List<Float> weights;

    /**
     * An array of primitives, each defining geometry to be rendered with a 
     * material. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;Geometry to be rendered with the given material. 
     * (optional) 
     * 
     * @param primitives The primitives to set
     * @throws NullPointerException If the given value is <code>null</code>
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setPrimitives(List<MeshPrimitive> primitives) {
        if (primitives == null) {
            throw new NullPointerException((("Invalid value for primitives: "+ primitives)+", may not be null"));
        }
        if (primitives.size()< 1) {
            throw new IllegalArgumentException("Number of primitives elements is < 1");
        }
        this.primitives = primitives;
    }

    /**
     * An array of primitives, each defining geometry to be rendered with a 
     * material. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;Geometry to be rendered with the given material. 
     * (optional) 
     * 
     * @return The primitives
     * 
     */
    public List<MeshPrimitive> getPrimitives() {
        return this.primitives;
    }

    /**
     * Add the given primitives. The primitives of this instance will be 
     * replaced with a list that contains all previous elements, and 
     * additionally the new element. 
     * 
     * @param element The element
     * @throws NullPointerException If the given element is <code>null</code>
     * 
     */
    public void addPrimitives(MeshPrimitive element) {
        if (element == null) {
            throw new NullPointerException("The element may not be null");
        }
        List<MeshPrimitive> oldList = this.primitives;
        List<MeshPrimitive> newList = new ArrayList<MeshPrimitive>();
        if (oldList!= null) {
            newList.addAll(oldList);
        }
        newList.add(element);
        this.primitives = newList;
    }

    /**
     * Remove the given primitives. The primitives of this instance will be 
     * replaced with a list that contains all previous elements, except for 
     * the removed one. 
     * 
     * @param element The element
     * @throws NullPointerException If the given element is <code>null</code>
     * 
     */
    public void removePrimitives(MeshPrimitive element) {
        if (element == null) {
            throw new NullPointerException("The element may not be null");
        }
        List<MeshPrimitive> oldList = this.primitives;
        List<MeshPrimitive> newList = new ArrayList<MeshPrimitive>();
        if (oldList!= null) {
            newList.addAll(oldList);
        }
        newList.remove(element);
        this.primitives = newList;
    }

    /**
     * Array of weights to be applied to the Morph Targets. (optional)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;The elements of this array (optional) 
     * 
     * @param weights The weights to set
     * @throws IllegalArgumentException If the given value does not meet
     * the given constraints
     * 
     */
    public void setWeights(List<Float> weights) {
        if (weights == null) {
            this.weights = weights;
            return ;
        }
        if (weights.size()< 1) {
            throw new IllegalArgumentException("Number of weights elements is < 1");
        }
        this.weights = weights;
    }

    /**
     * Array of weights to be applied to the Morph Targets. (optional)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;The elements of this array (optional) 
     * 
     * @return The weights
     * 
     */
    public List<Float> getWeights() {
        return this.weights;
    }

    /**
     * Add the given weights. The weights of this instance will be replaced 
     * with a list that contains all previous elements, and additionally the 
     * new element. 
     * 
     * @param element The element
     * @throws NullPointerException If the given element is <code>null</code>
     * 
     */
    public void addWeights(Float element) {
        if (element == null) {
            throw new NullPointerException("The element may not be null");
        }
        List<Float> oldList = this.weights;
        List<Float> newList = new ArrayList<Float>();
        if (oldList!= null) {
            newList.addAll(oldList);
        }
        newList.add(element);
        this.weights = newList;
    }

    /**
     * Remove the given weights. The weights of this instance will be 
     * replaced with a list that contains all previous elements, except for 
     * the removed one.<br> 
     * If this new list would be empty, then it will be set to 
     * <code>null</code>. 
     * 
     * @param element The element
     * @throws NullPointerException If the given element is <code>null</code>
     * 
     */
    public void removeWeights(Float element) {
        if (element == null) {
            throw new NullPointerException("The element may not be null");
        }
        List<Float> oldList = this.weights;
        List<Float> newList = new ArrayList<Float>();
        if (oldList!= null) {
            newList.addAll(oldList);
        }
        newList.remove(element);
        if (newList.isEmpty()) {
            this.weights = null;
        } else {
            this.weights = newList;
        }
    }

}
