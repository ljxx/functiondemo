package www.function.com.functiondemo.ui.function.pulign;

import android.text.Html;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import www.function.com.functiondemo.utils.HtmlUrl;

/**
 * Created by yanglixiang on 2016/7/5.
 */
public class Rss extends CordovaPlugin {

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
        }
        return false;
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
