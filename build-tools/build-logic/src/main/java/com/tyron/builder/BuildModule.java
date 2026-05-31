package com.tyron.builder;

import android.content.Context;
import android.os.Environment;

import androidx.annotation.NonNull;

import com.tyron.common.util.Decompress;

import java.io.File;

public class BuildModule {

    private static Context sApplicationContext;
    private static File sAndroidJar;
    private static File sLambdaStubs;

    public static void initialize(Context applicationContext) {
            sApplicationContext = applicationContext.getApplicationContext();
    }

    public static Context getContext() {
        return sApplicationContext;
    }

    public static File getAndroidJar() {
        if (sAndroidJar == null) {
            Context context = BuildModule.getContext();
            if (context == null) {
                return null;
            }

            sAndroidJar = new File(new File(Environment.getExternalStorageDirectory(), "CodeAssist/projects"), "rt.jar");
            if (!sAndroidJar.exists()) {
                Decompress.unzipFromAssets(BuildModule.getContext(),
                        "rt.zip",
                        sAndroidJar.getParentFile().getAbsolutePath());
            }
        }

        return sAndroidJar;
    }

    public static File getLambdaStubs() {
        if (sLambdaStubs == null) {
            sLambdaStubs = new File(new File(Environment.getExternalStorageDirectory(), "CodeAssist/projects"), "core-lambda-stubs.jar");

            if (!sLambdaStubs.exists()) {
                Decompress.unzipFromAssets(BuildModule.getContext(), "lambda-stubs.zip", sLambdaStubs.getParentFile().getAbsolutePath());
            }
        }
        return sLambdaStubs;
    }

    public static void setAndroidJar(@NonNull File jar) {
        sAndroidJar = jar;
    }

    public static void setLambdaStubs(File file) {
        sLambdaStubs = file;
    }
}
