/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hkh.moyiza;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.hkh.moyiza.config.Config;

/**
 * An ad listener that toasts all ad events.
 */
public class ToastAdListener extends AdListener {
    private Context mContext;

    public ToastAdListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onAdLoaded() {
    	if (Config.AdToast) {
    		Toast.makeText(mContext, "onAdLoaded()", Toast.LENGTH_SHORT).show();
    	}
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        String errorReason = "";
        switch(errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorReason = "Internal error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorReason = "Invalid request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorReason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                errorReason = "No fill";
                break;
        }
        if (Config.AdToast) {
        	Toast.makeText(mContext, String.format("onAdFailedToLoad(%s)", errorReason),
        			Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAdOpened() {
    	if (Config.AdToast) {
    		Toast.makeText(mContext, "onAdOpened()", Toast.LENGTH_SHORT).show();
    	}
    }

    @Override
    public void onAdClosed() {
    	if (Config.AdToast) {
    		Toast.makeText(mContext, "onAdClosed()", Toast.LENGTH_SHORT).show();
    	}
    }

    @Override
    public void onAdLeftApplication() {
    	if (Config.AdToast) {
    		Toast.makeText(mContext, "onAdLeftApplication()", Toast.LENGTH_SHORT).show();
    	}
    }
}
