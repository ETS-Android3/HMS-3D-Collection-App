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

package com.huawei.cameratakelib;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.huawei.cameratakelib.listener.CameraTakeListener;
import com.huawei.hms.magicresource.view.ResizeAbleSurfaceView;

public class CameraTakeManager {

    Activity activity;
    ResizeAbleSurfaceView surfaceView;
    CameraTakeListener listener;

    SurfaceHolder surfaceHolder;

    public SurfaceViewCallback getSurfaceViewCallback() {
        return surfaceViewCallback;
    }

    SurfaceViewCallback surfaceViewCallback;


    public CameraTakeManager(Activity activity, ResizeAbleSurfaceView surfaceView, CameraTakeListener listener) {
        this.activity = activity;
        this.surfaceView = surfaceView;
        this.listener = listener;

        surfaceViewCallback = new SurfaceViewCallback(activity, listener,surfaceView);
        initCamera();
    }

    public CameraTakeManager(Activity activity, ResizeAbleSurfaceView surfaceView, CameraTakeListener listener, int model){
        this.activity = activity;
        this.surfaceView = surfaceView;
        this.listener = listener;

        surfaceViewCallback = new SurfaceViewCallback(activity, listener, model, surfaceView);
        initCamera();
    }

    /**
     * 初始化相机
     */
    private void initCamera() {
        //在surfaceView中获取holder
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(surfaceViewCallback);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    /**
     * 获取相机当前的照片
     * */
    public void takePhoto() {
        surfaceViewCallback.takePhoto();
    }
    /**
     * 获取相机当前的照片
     * */
    public void takePhoto(int top, int width) {
        surfaceViewCallback.takePhoto(top, width);
    }

    public void destroy() {
        surfaceViewCallback.destroy();
    }

    public void takePhotoRgb(float ratio, int type) {
        surfaceViewCallback.takePhotoRgb( ratio,type);
    }

}
