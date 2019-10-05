package me.zhaoming.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * 作者：贪欢
 * 时间：2019/7/7
 * 描述：多行单选框
 */
public class MultiLineRadioGroup extends RadioGroup {

    private OnCheckedChangeListener mOnCheckedChangeListener;
    private int mCheckId;


    public int getCheckId() {
        return mCheckId;
    }

    public void setmCheckId(int mCheckId) {
        this.mCheckId = mCheckId;
    }

    public MultiLineRadioGroup(Context context) {
        super(context);
    }

    public MultiLineRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    @Override
    public void addView(final View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof ViewGroup) {
            int childCount = ((ViewGroup) child).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = ((ViewGroup) child).getChildAt(i);
                if (view instanceof RadioButton) {
                    final RadioButton button = (RadioButton) view;
                     button.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             button.setChecked(true);
                            checkRadioButton( button);
                            setmCheckId(button.getId());
                            if (mOnCheckedChangeListener != null) {
                                mOnCheckedChangeListener.onCheckedChanged(MultiLineRadioGroup.this,mCheckId );
                            }
                        }
                    });

                }
            }
        }

        super.addView(child, index, params);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private void checkRadioButton(RadioButton radioButton) {
        View child;
        int radioCount = getChildCount();
        for (int i = 0; i < radioCount; i++) {
            child = getChildAt(i);
            if (child instanceof RadioButton) {
                if (child == radioButton) {
                    // do nothing
                } else {
                    ((RadioButton) child).setChecked(false);
                }
            } else if (child instanceof ViewGroup) {
                int childCount = ((ViewGroup) child).getChildCount();
                for (int j = 0; j < childCount; j++) {
                    View view = ((ViewGroup) child).getChildAt(j);
                    if (view instanceof RadioButton) {
                        final RadioButton button = (RadioButton) view;
                        if (button == radioButton) {
                            // do nothing
                        } else {
                            button.setChecked(false);
                        }
                    }
                }
            }
        }
    }

}
