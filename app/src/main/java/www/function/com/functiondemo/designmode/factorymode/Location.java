package www.function.com.functiondemo.designmode.factorymode;

/**
 * 获取地址接口
 */
public interface Location {
    public void getPosition();
    public void getCityName(long lat,long lng);
}
