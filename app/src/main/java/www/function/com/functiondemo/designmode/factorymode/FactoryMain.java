package www.function.com.functiondemo.designmode.factorymode;

/**
 * 主函数入口
 */
public class FactoryMain {
    public static void main(String[] args){
        Location location = new LocationFactory().getInstance("baidu");
        location.getPosition();
        location.getCityName(10,20);
    }
}
