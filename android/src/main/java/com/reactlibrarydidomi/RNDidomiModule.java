package com.reactlibrarydidomi;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.app.Application;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import io.didomi.sdk.Didomi;

public class RNDidomiModule extends ReactContextBaseJavaModule {

  	private final ReactApplicationContext reactContext;

  	public RNDidomiModule(ReactApplicationContext reactContext) {
    	super(reactContext);
    	this.reactContext = reactContext;
  	}

  	@Override
  	public String getName() {
    	return "RNDidomi";
  	}

	@ReactMethod
	public void init(String apiKey, Sting remoteUrl) {
		try {
			Didomi.getInstance().setLogLevel(android.util.Log.DEBUG);
        	Didomi.getInstance().initialize(
                this.reactContext.getCurrentActivity().getApplication(),
                apiKey,
                null,
                remoteUrl,
                null,
				remoteUrl == null
			);
            
            // Do not use the Didomi.getInstance() object here for anything else than registering your ready listener
            // The SDK might not be ready yet
            
            Didomi.getInstance().onReady(() -> {
				// The SDK is ready, you can now interact with it
				Log.i("App", "DIDOMI SDK READY");
				Didomi.getInstance().setupUI((AppCompatActivity)this.reactContext.getCurrentActivity());
            });
        } catch(Exception e) {
            Log.e("App", "Error while initializing the Didomi SDK", e);
        }
	}	

	@ReactMethod
	public void showNotice() {
		try {
			Didomi.getInstance().showNotice((AppCompatActivity)this.reactContext.getCurrentActivity());
		} catch(Exception e) {
			Log.e("App", "Error while showing notice", e);
		}
	}

	@ReactMethod
	public void hideNotice() {
		try {
			Didomi.getInstance().hideNotice();
		} catch(Exception e) {
			Log.e("App", "Error while hiding notice", e);
		}
	}

	@ReactMethod
	public void showPreferences() {
		try {
			Didomi.getInstance().showPreferences((AppCompatActivity)this.reactContext.getCurrentActivity());
		} catch(Exception e) {
			Log.e("App", "Error while showing preferences", e);
		}
	}

	@ReactMethod
	public void hidePreferences() {
		try {
			Didomi.getInstance().hidePreferences();
		} catch(Exception e) {
			Log.e("App", "Error while hiding preferences", e);
		}
	}
}