package www.function.com.functiondemo.ui.function.pulign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import www.function.com.functiondemo.ui.function.slidingtab.activity.DetailsActivity;
import www.function.com.functiondemo.utils.HtmlUrl;

/**
 * Created by yanglixiang on 2016/7/5.
 */
public class Rss extends CordovaPlugin {

    private CallbackContext mCallbackContext;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        return super.execute(action, args, callbackContext);
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        return super.execute(action, args, callbackContext);
    }

    @Override
    public boolean execute(String action, String rawArgs, CallbackContext callbackContext) throws JSONException {
        if(HtmlUrl.SENDUSERDATA.equals(action)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", HtmlUrl.USERID);
            callbackContext.success(jsonObject);
            return true;
        } else if(HtmlUrl.SENDENV.equals(action)){
            JSONObject jsonUrl = new JSONObject();
            jsonUrl.put("search",HtmlUrl.SEARCH);
            jsonUrl.put("auction",HtmlUrl.AUCTION);
            jsonUrl.put("push",HtmlUrl.PUSH);
            jsonUrl.put("user",HtmlUrl.USER);
            jsonUrl.put("meta",HtmlUrl.META);
            jsonUrl.put("pub",HtmlUrl.PUB);
            callbackContext.success(jsonUrl);
            return true;
        } else if(HtmlUrl.RECEIVEDETAILDATA.equals(action)){
            this.mCallbackContext = mCallbackContext;
            Intent mIntent = new Intent(cordova.getActivity(),DetailsActivity.class);
            mIntent.putExtra("rawArgs",rawArgs);
            cordova.startActivityForResult(this,mIntent,1);
            PluginResult mPlugin = new PluginResult(PluginResult.Status.NO_RESULT);
            mPlugin.setKeepCallback(true);
            callbackContext.sendPluginResult(mPlugin);
            return true;
        }
        return false;
    }

    /**
     * 第二个Activity返回时执行完后的回调接收方法
     * @param requestCode
     * @param resultCode
     * @param intent
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        System.out.println("==Rss====onActivityResult===执行啦=======");
        switch (resultCode){ //resultCode为回传的标记，我在第二个Activity中回传的是RESULT_OK
            case Activity.RESULT_OK:
                Bundle mBundle = intent.getExtras();
                String rewgs = mBundle.getString("rawArgs");
                System.out.println("===Rss===rewgs===执行啦=======:" + rewgs);

                //通过PluginResult和callbackContext返回给js接口
               /* PluginResult pluginResults = new PluginResult(PluginResult.Status.OK, str);
                mCallbackContext.sendPluginResult(pluginResults);
                pluginResults.setKeepCallback(true);
                mCallbackContext.success();*/
                break;
            default:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("===Rss===onStart===执行啦=======:");
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        System.out.println("===Rss===onResume===执行啦=======:");
    }

    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
        System.out.println("===Rss===onResume===执行啦=======:");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("===Rss===onStop===执行啦=======:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("===Rss===onDestroy===执行啦=======:");
    }

    @Override
    public Boolean shouldAllowNavigation(String url) {
        return true;
    }
    @Override
    public Boolean shouldAllowRequest(String url) {
        return true;
    }
}
