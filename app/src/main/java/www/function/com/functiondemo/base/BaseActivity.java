package www.function.com.functiondemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * ============================================================
 * .
 * 版 权 ： 上海赵涌信息技术有限公司 版权所有 (c) 2015
 * .
 * 作 者 : YangLiXiang
 * .
 * 版 本 ： functiondemo
 * .
 * 创建日期 ：2016/4/20 11:47
 * .
 * 描 述 ：
 * .
 * 修订历史 ：
 * .
 * ============================================================
 **/
public class BaseActivity extends Activity {

    /**
     * 页面跳转
     * @param context 上下文对象
     * @param clzz 泛型
     */
    protected void jumpActivity(Context context,Class<?> clzz){
        startActivity(new Intent(context,clzz));
    }
}
