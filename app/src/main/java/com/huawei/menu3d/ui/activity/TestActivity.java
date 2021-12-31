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

package com.huawei.menu3d.ui.activity;

import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.materialgeneratesdk.cloud.Modeling3dTextureEngine;
import com.huawei.hms.materialgeneratesdk.cloud.Modeling3dTextureTaskUtils;
import com.huawei.hms.objreconstructsdk.Modeling3dReconstructConstants;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructEngine;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructInitResult;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructPreviewListener;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructQueryResult;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructSetting;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructTaskUtils;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructUploadListener;
import com.huawei.hms.objreconstructsdk.cloud.Modeling3dReconstructUploadResult;
import com.huawei.menu3d.MainActivity;
import com.huawei.menu3d.databinding.ActivityMainBinding;

import java.io.File;

public class TestActivity extends AppCompatActivity {

    private Modeling3dReconstructInitResult modeling3dReconstructInitResult;
    private Modeling3dReconstructEngine modeling3dReconstructEngine;

    String filePath = "";
    String savePath = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        filePath = Environment.getExternalStorageDirectory().getAbsoluteFile().toString() +
                File.separator + "3dupload" +File.separator;
        savePath = new String();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            savePath = this.getExternalFilesDir(null).toString() + "/3dModeling/";
        } else {
            savePath = this.getFilesDir().getPath() + "/3dModeling/";
        }
        savePath = savePath + "material/download/";
        File file = new File(savePath);
        boolean  isNewFileCreated = file.mkdir();
        if(isNewFileCreated){
            System.out.println(" File is created successfully.");
        } else{
            System.out.println(" File already exists.");
         }
        this.initializeEngine();

    }
    public void initializeEngine() {
         Modeling3dReconstructEngine modeling3dReconstructEngine = Modeling3dReconstructEngine.getInstance(MainActivity.app);
         Modeling3dReconstructSetting setting = new Modeling3dReconstructSetting.Factory()
                .setReconstructMode(Modeling3dReconstructConstants.ReconstructMode.PICTURE)
                .create();
    }
    private Modeling3dReconstructUploadListener uploadListener = new Modeling3dReconstructUploadListener() {
        @Override
        public void onUploadProgress(String taskId, double progress, Object ext) {
            // Upload progress.
        }
        @Override
        public void onResult(String taskId, Modeling3dReconstructUploadResult result, Object ext) {
            // Called upon upload success.
        }
        @Override
        public void onError(String taskId, int errorCode, String message) {
            // Called upon upload failure.
        }
    };

    private void configuratorTask(Modeling3dReconstructSetting setting){
        modeling3dReconstructInitResult = modeling3dReconstructEngine.initTask(setting);
        String taskId = modeling3dReconstructInitResult.getTaskId();
        if (taskId == null || taskId.equals("")) {
            Log.e("","get taskID error " + modeling3dReconstructInitResult.getRetMsg());
        } else {
            // Set the upload listener.
            modeling3dReconstructEngine.setReconstructUploadListener(uploadListener);
            // Upload collected images.
            modeling3dReconstructEngine.uploadFile(taskId, filePath);
        }
    }

    private int queryTaskStatus(String taskId){
        int status = 0;
         Modeling3dReconstructTaskUtils modeling3dReconstructTaskUtils = Modeling3dReconstructTaskUtils.getInstance(MainActivity.app);
         Modeling3dReconstructQueryResult queryResult = modeling3dReconstructTaskUtils.queryTask(taskId);
         if (queryResult.getRetCode() == 0) {
            // Obtain the status of the 3D object reconstruction task.
            status = queryResult.getStatus();
        } else {
            Log.e("","Get task status failed" + queryResult.getRetCode());
        }
         return  status;
    }

    private Modeling3dReconstructPreviewListener previewListener = new Modeling3dReconstructPreviewListener() {
        @Override
        public void onResult(String taskId, Object ext) {
            // Result of 3D model preview.
        }
        @Override
        public void onError(String taskId, int errorCode, String message) {
            // Called upon a preview error.
        }
    };
    // Preview a model.
    private void PreviewModel(String taskId){
        modeling3dReconstructEngine.previewModel(taskId, MainActivity.app, previewListener);

    }
}
