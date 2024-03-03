package com.example.javamvvm.utils;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogHelper {
    public static AlertDialog dialog(
            @NonNull Context activity,
            @StringRes Integer title,
            @Nullable String titleText,
            @StringRes Integer content,
            @Nullable String contentText,
            @StringRes int positive,
            @Nullable Integer negative,
            @Nullable Integer neutral,
            boolean isCancel,
            @Nullable Runnable onPositiveListener,
            @Nullable Runnable onNegativeListener,
            @Nullable Runnable onNeutralListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle(title != null ? activity.getString(title) : titleText)
                .setMessage(content != null ? activity.getString(content) : contentText)
                .setPositiveButton(positive, (dialog, which) -> {
                    dialog.dismiss();
                    if (onPositiveListener != null) {
                        onPositiveListener.run();
                    }
                })
                .setCancelable(isCancel);

        if (negative != null) {
            builder.setNegativeButton(negative, (dialog, which) -> {
                dialog.dismiss();
                if (onNegativeListener != null) {
                    onNegativeListener.run();
                }
            });
        }

        if (neutral != null) {
            builder.setNeutralButton(neutral, (dialog, which) -> {
                dialog.dismiss();
                if (onNeutralListener != null) {
                    onNeutralListener.run();
                }
            });
        }

        return builder.show();
    }

}
