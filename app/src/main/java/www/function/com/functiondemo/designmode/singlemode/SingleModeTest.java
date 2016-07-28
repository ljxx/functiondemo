package www.function.com.functiondemo.designmode.singlemode;

/**
 *   一、作用
 *   单例模式（Singleton）：保证一个类仅有一个实例，并提供一个访问它的全局访问点
 *   二、适用场景
 *   1. 应用中某个实例对象需要频繁的被访问。
 *   2. 应用中每次启动只会存在一个实例。如账号系统，数据库系统。
 */
public class SingleModeTest {


    /**
     * *****************************懒*汉*式*******************************
     */

    //持有私有静态对象，防止被引用，此处赋值null,目的实现延迟加载
    private static SingleModeTest singleModeTest = null;

    /**
     * 私有构造函数，防止被实例化
     */
//    private SingleModeTest(){}

    /**
     *
     * （1）懒汉式（线程不安全）
     *
     * 懒汉式，静态工程方法，创建实例
     *
     * 懒汉式（线程不安全）的单例模式分为三个部分：私有的构造方法，私有的全局静态变量，公有的静态方法。
     * 其中起到重要作用的是静态修饰符static关键字，我们知道在程序中，任何变量或者代码都是在编译时由系统自动分配内存来存储的，
     * 而所谓静态就是指在编译后所分配的内存会一直存在，直到程序退出内存才会释放这个空间，因此也就保证了单例类的实例一旦创建，
     * 便不会被系统回收，除非手动设置为null。
     * 这种方式创建的缺点是存在线程不安全的问题，解决的办法就是使用synchronized 关键字，便是单例模式的第二种写法了。
     */
    /*public static SingleModeTest getSingleObject(){
        if(singleModeTest == null){
            singleModeTest = new SingleModeTest();
        }
        return singleModeTest;
    }*/

    /**
     * (2)懒汉式（线程安全）
     *
     * 公有的同步静态方法
     *
     * 这种单例实现方式的getInstance（）方法中添加了synchronized 关键字，也就是告诉Java（JVM）getInstance是一个同步方法。
     * 同步的意思是当两个并发线程访问同一个类中的这个synchronized同步方法时， 一个时间内只能有一个线程得到执行，
     * 另一个线程必须等待当前线程执行完才能执行，因此同步方法使得线程安全，保证了单例只有唯一个实例。
     * 但是它的缺点在于每次调用getInstance（）都进行同步，造成了不必要的同步开销。这种模式一般不建议使用。
     */
    /*public static synchronized SingleModeTest getSingleObject2(){
        if(singleModeTest == null){
            singleModeTest = new SingleModeTest();
        }
        return singleModeTest;
    }*/

    /**
     * (3)DCL双重校验模式
     *
     * 这种模式的亮点在于getInstance（）方法上，其中对singleton 进行了两次判断是否空，第一层判断是为了避免不必要的同步，
     * 第二层的判断是为了在null的情况下才创建实例。具体我们来分析一下：
     *
     * 假设线程A执行到了singleton = new Singleton(); 语句，这里看起来是一句代码，但是它并不是一个原子操作，
     * 这句代码最终会被编译成多条汇编指令，它大致会做三件事情：
     * （a）给Singleton的实例分配内存
     * （b）调用Singleton（）的构造函数，初始化成员字段；
     * （c）将singleton对象指向分配的内存空间（即singleton不为空了）；
     *
     * 但是由于Java编译器允许处理器乱序执行，以及在jdk1.5之前，JMM（Java Memory Model：java内存模型）
     * 中Cache、寄存器、到主内存的回写顺序规定，上面的步骤b 步骤c的执行顺序是不保证了。也就是说执行顺序可能是a-b-c，
     * 也可能是a-c-b,如果是后者的指向顺序，并且恰恰在c执行完毕，b尚未执行时，被切换到线程B中，
     * 这时候因为singleton在线程A中执行了步骤c了，已经非空了，所以，线程B直接就取走了singleton，
     * 再使用时就会出错。这就是DCL失效问题。
     * 但是在JDK1.5之后，官方给出了volatile关键字，将singleton定义的代码改成：
     *
     * private volatile static Singleton singleton;  //使用volatile 关键字
     *
     * 这样就解决了DCL失效的问题。
     */
    /*public static SingleModeTest getSingleObject3(){
        if(singleModeTest == null){
            synchronized (SingleModeTest.class){
                if(singleModeTest == null){
                    singleModeTest = new SingleModeTest();
                }
            }
        }
        return singleModeTest;
    }*/

    /**
     * *****************************静态内部类单例模式*******************************
     */

    /**
     * 当第一次加载Singleton 类的时候并不会初始化INSTANCE ，
     * 只有第一次调用Singleton 的getInstance（）方法时才会导致INSTANCE 被初始化。
     * 因此，第一次调用getInstance（）方法会导致虚拟机加载SingletonHolder 类，
     * 这种方式不仅能够确保单例对象的唯一性，同时也延迟了单例的实例化。
     */
    //定义静态内部类
    private static class SingleHolder{
        private static final SingleModeTest SINGLEMODETEST = new SingleModeTest(); //创建实例
    }
    private SingleModeTest(){}
    public static SingleModeTest getSingleObject4(){
        return SingleHolder.SINGLEMODETEST;
    }





    /**
     * *****************************饿*汉*式*******************************
     */

    /**
     * 饿汉式
     * 当类初始化时，就已经自动实例化了
     *
     * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
     */
    //static修饰的静态变量在内存中，一旦创建，便永久存在
   /*
    private static SingleModeTest singleModeTest = new SingleModeTest();
    private SingleModeTest(){}
    private static SingleModeTest getSingleObject(){
        return singleModeTest;
    }
    */
}

/**
 * 枚举单例模式最大的优点就是写法简单，枚举在java中与普通的类是一样的，
 * 不仅能够有字段，还能够有自己的方法，最重要的是默认枚举实例是线程安全的，
 * 并且在任何情况下，它都是一个单例。即使是在反序列化的过程，枚举单例也不会重新生成新的实例。
 */
/*public enum SingleEnum{
    INSINGLE;
    public void whateverMethod(){}
}*/

