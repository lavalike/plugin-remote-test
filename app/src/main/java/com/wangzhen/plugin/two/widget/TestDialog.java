package com.wangzhen.plugin.two.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.wangzhen.plugin.two.R;

/**
 * TestDialog
 * Created by wangzhen on 2020/4/20.
 */
public class TestDialog extends Dialog {
    public TestDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflate = View.inflate(getContext(), R.layout.dialog_confirm_layout, null);
        inflate.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        inflate.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        setContentView(inflate);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels * 5 / 6;
            attributes.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            window.setAttributes(attributes);
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
