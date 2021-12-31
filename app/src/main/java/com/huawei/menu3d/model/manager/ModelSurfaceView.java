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

package com.huawei.menu3d.model.manager;


import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.huawei.menu3d.model.controller.TouchController;

import java.io.IOException;

/**
 * This is the actual opengl view. From here we can detect touch gestures for example
 *
 * @author andresoviedo
 *
 */
public class ModelSurfaceView extends GLSurfaceView {

    private ModelActivity parent;
    private ModelRenderer mRenderer;
    private TouchController touchHandler;

    public ModelSurfaceView(ModelActivity parent) throws IllegalAccessException, IOException {
        super(parent);

        // parent component
        this.parent = parent;

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // This is the actual renderer of the 3D space
        mRenderer = new ModelRenderer(this);
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        // TODO: enable this?
        // setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        touchHandler = new TouchController(this, mRenderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return touchHandler.onTouchEvent(event);
    }

    public ModelActivity getModelActivity() {
        return parent;
    }

    public ModelRenderer getModelRenderer(){
        return mRenderer;
    }

}