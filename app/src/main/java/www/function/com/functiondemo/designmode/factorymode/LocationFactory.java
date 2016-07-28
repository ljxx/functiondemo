package www.function.com.functiondemo.designmode.factorymode;

/**
 * 工厂
 */
public class LocationFactory {
    public static Location getInstance(String type){
        if("baidu".equals(type)){
            return new BaiduLocation();
        } else if("xiaomi".equals(type)){
            return new XiaoMiLocation();
        } else if("gaode".equals(type)){
            return new GoogleLocation();
        } else {
            return new GaoDeLocation();
        }
    }
}
