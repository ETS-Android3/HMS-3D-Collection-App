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

package com.huawei.menu3d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.menu3d.model.manager.MenuActivity;




public class MainActivity extends AppCompatActivity {

    public static MainActivity app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }
     public void loadModel(View view) {
        Intent intent = new Intent(this, MenuActivity.class);

        startActivity(intent);
    }
     public void uploadModel(View view) {
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onResume() {
        super.onResume();
    }


}