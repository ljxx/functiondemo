package www.function.com.functiondemo.designmode;

import www.function.com.functiondemo.designmode.factorymode.Location;
import www.function.com.functiondemo.designmode.factorymode.LocationFactory;
import www.function.com.functiondemo.designmode.singlemode.SingleModeTest;

/**
 * 主函数入口
 */
public class FactoryMain {

    public static void main(String[] args){
        /**
         * 工厂模式
         */
        getFactoryMode();

        /**
         * 单例模式
         */
        getSingleMode();
    }

    /**
     * 本实例较好的阐述了工厂模式的概念。LocationFactory是一个工厂类，静态函数getInstance的参数决定了是选用百度还是高德，
     * 这样，对于调用者来说，只需要关心你是用百度还是高德即可。Location是一个接口，它抽象出高德和百度常用的函数调用。
     * 拿定位来说，基本上常用的就是根据经纬度查询地址，或者定位当前所在位置获取经纬度。当然可能还有更多有用的函数，
     * 我这里就不在列举。有了这样一个共性的接口，XiaoMiLocation和BaiduLocation通过实现它的接口就能分别满足调用者的需求。
     * 调用者就能够任意通过改变参数，来实现来自不同定位API的需求。当然，如果百度和高德不爽，你完全可以使用谷歌API，
     * 只需要构造一个GoogleLocation类并实现Location接口的方法即可。
     *
     * 工厂模式的应用非常广泛，比如android的bitmap中常用的BitmapFactory类，创建Bitmap对象，通常使用静态工厂方法。
     */
    public static void getFactoryMode(){
        Location location = new LocationFactory().getInstance("baidu");
        location.getPosition();
        location.getCityName(10,20);
    }

    /**
     * 单例模式是设计模式中最常见也最简单的一种设计模式，保证了在程序中只有一个实例存在并且能全局的访问到。
     * 比如在android实际APP 开发中用到的 账号信息对象管理，
     * 数据库对象（SQLiteOpenHelper）等都会用到单例模式。
     * 下面针对一些例子分析一下我们在开发过程中应用单例模式需要注意的点。
     */
    public static void getSingleMode(){
//        SingleModeTest.getSingleObject()
    }
}
