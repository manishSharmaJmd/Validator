package com.cjsvm.validator;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

public class Validator {

    private static EditText[] editTextsAr;

    public static void attachValidator(EditText[] editTextAr, final TextWatcher textWatcher, final View.OnFocusChangeListener onFocusChangeListener) {

        if (editTextAr != null) {
            editTextsAr = editTextAr;
            for (int i = 0; i < editTextAr.length; i++) {

                final EditText editText = editTextAr[i];
                final Drawable background = editText.getBackground();
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        if (textWatcher != null) {
                            textWatcher.beforeTextChanged(charSequence, i, i1, i2);
                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if (textWatcher != null) {
                            textWatcher.onTextChanged(charSequence, i, i1, i2);
                        }
                        if (TextUtils.isEmpty(charSequence.toString())) {
                            editText.setBackgroundResource(R.drawable.error_style);
                        } else {

                            if (background != null) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    editText.setBackground(background);
                                } else {
                                    editText.setBackgroundDrawable(background);

                                }
                            } else {
                                editText.setBackgroundResource(0);
                            }
                        }

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        if (textWatcher != null) {
                            textWatcher.afterTextChanged(editable);
                        }
                    }
                });
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if (onFocusChangeListener != null)
                            onFocusChangeListener.onFocusChange(view, b);

                        if (!b) {
                            if (TextUtils.isEmpty(editText.getText().toString())) {
                                editText.setBackgroundResource(R.drawable.error_style);
                            }
                        } else {
                            if (background != null) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    editText.setBackground(background);
                                } else {
                                    editText.setBackgroundDrawable(background);

                                }
                            } else {
                                editText.setBackgroundResource(0);
                            }
                        }
                    }
                });


            }

        }
    }

    public static boolean isValidated() {

        boolean result = true;
        String position = "";

        if (editTextsAr != null) {
            for (int i = 0; i < editTextsAr.length; i++) {


                if (TextUtils.isEmpty(editTextsAr[i].getText().toString())) {
                    result = false;
                    if (TextUtils.isEmpty(position))
                        position = "" + i;
                    editTextsAr[i].setBackgroundResource(R.drawable.error_style);

                    editTextsAr[i].startAnimation(shakeError());
                }
            }
            if (!result) {

                if (!TextUtils.isEmpty(position)) {
                    editTextsAr[Integer.parseInt(position)].requestFocus();
                }
            }

        } else {
            result = false;
        }


        return result;
    }

    private static TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(2));
        return shake;
    }
}
