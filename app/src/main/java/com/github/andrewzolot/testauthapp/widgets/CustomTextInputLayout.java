package com.github.andrewzolot.testauthapp.widgets;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.andrewzolot.testauthapp.R;

/**
 * Custom TextInoutLayout which allow to change hint color
 * Taken from https://stackoverflow.com/questions/38327430/textinputlayout-different-color-for-hint-label-when-not-focused
 */

public class CustomTextInputLayout extends TextInputLayout{

    private boolean emptyText = true;
    private static final int[] EMPTY_TEXT_STATE = new int[]{R.attr.state_empty_text};
    public CustomTextInputLayout(Context context) {
        super(context);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] state = super.onCreateDrawableState(extraSpace + 1);
        if (emptyText) {
            mergeDrawableStates(state, EMPTY_TEXT_STATE);
        }
        return state;
    }

    public void setEmptyTextState(boolean emptyTextState) {
        this.emptyText = emptyTextState;
        refreshDrawableState();
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof EditText) {
            EditText editText = (EditText) child;
            if (!TextUtils.isEmpty(editText.getText())) {
                setEmptyTextState(false);
            }
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (!TextUtils.isEmpty(editable)) {
                        setEmptyTextState(false);
                    } else {
                        setEmptyTextState(true);
                    }
                }
            });
        }
        super.addView(child, index, params);
    }
}
