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

package com.huawei.hms.modeling3d.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.huawei.hms.magicresource.db.TaskInfoAppDb;
import com.huawei.hms.magicresource.util.Utils;
import com.huawei.menu3d.R;
import com.huawei.hms.modeling3d.ui.fragment.HistoryModelDataFragment;

public class SelectModelDialog extends Dialog {
    Context mContext;
    RelativeLayout rlRgb;
    RelativeLayout rlSlam;
    ImageView ivRgb;
    ImageView ivSlam;
    TextView tvCancel;
    HistoryModelDataFragment dataFragment;
    TaskInfoAppDb appDb;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    String model = "OBJ";

    public SelectModelDialog(@NonNull Context context, HistoryModelDataFragment fragment, TaskInfoAppDb appDb) {
        super(context, R.style.BottomAnimDialogStyle);
        this.mContext = context;
        dataFragment = fragment;
        this.appDb = appDb;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.select_model_dialog_layout, null);
        Window window = this.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.y = Utils.dip2px(mContext, 16);
            window.setAttributes(lp);
        }
        initView(view);
        setContentView(view);
    }

    private void initView(View view) {
        rlRgb = view.findViewById(R.id.rl_rgb);
        rlSlam = view.findViewById(R.id.rl_slam);
        ivRgb = view.findViewById(R.id.iv_rgb);
        ivSlam = view.findViewById(R.id.iv_slam);
        tvCancel = view.findViewById(R.id.tv_cancel);
        rlRgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivRgb.setImageResource(R.drawable.select_rb_icon);
                ivSlam.setImageResource(R.drawable.unselect_rb_icon);
                model = "GLTF";
            }
        });
        rlSlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivRgb.setImageResource(R.drawable.unselect_rb_icon);
                ivSlam.setImageResource(R.drawable.select_rb_icon);
                model = "OBJ";
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataFragment.showNewDownLoad(appDb, model);
                dismiss();
            }
        });
    }
}
