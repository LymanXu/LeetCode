package reflection;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class Base {
    static int num = 1;

    static {
        System.out.println("Base " + num);
    }
}
/*
class Main {
    public static void main(String[] args) {
        // 不会初始化静态块
        Class clazz1 = Base.class;
        System.out.println("------");
        // 会初始化
        try {
            Class clazz2 = Class.forName("reflection.Base");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}*/

// 动态代理
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething.");
    }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
class DynamicProxyHandler implements InvocationHandler {
    private Object proxyed;

    public DynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("代理工作了.");
        return method.invoke(proxyed, args);
    }
}

class Main {
    public  static void main(String[] args) {
        RealObject real = new RealObject();
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[] {Interface.class},
                new DynamicProxyHandler(real));

        proxy.doSomething();
        proxy.somethingElse("luoxn28");
    }

}

/*动态代理可以做的事儿

    有一个CalcDao接口,提供加减乘除的四个简单方法,有一个CalcDaoImpl的实现类实现了CalcDao接口,现在要求在调用实现类中的每个方法之前提示方法开始执行,执行完成后提示执行完毕,并统计方法调用的时间.
如果在每个方法中分别添加以上需求的实现,代码重复量大,代码耦合度高,不利于维护,使用java的动态代理可以很轻松的实现以上需求.
使用Java的反射机制,创建动态代理对象.让代理对象在调用目标方法之前和之后分别做一些事情,然后动态代理对象决定是否调用以及何时来调用被代理对象的方法(可以加一些验证,验证不通过则不去调用目标方法,此处示例略)
     */
interface CalcDao {
    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);
}

class CalcDaoImpl implements CalcDao {

    @Override
    public int add(int i, int j) {
        int r = i + j;
        return r;
    }

    @Override
    public int sub(int i, int j) {
        int r = i - j;
        return r;
    }

    @Override
    public int mul(int i, int j) {
        int r = i * j;
        return r;
    }

    @Override
    public int div(int i, int j) {
        int r = i / j;
        return r;
    }

}

class Main2{
    /*
实现动态代理的步骤如下:
1、创建被代理的对象(接口类型)
2、通过代理类Proxy的newProxyInstance()方法创建代理对象
3、newProxyInstance()方法的三个参数:
      3.1 ClassLoader:类加载器,即代理对象使用哪个类加载器进行加载,一般和被代理对象使用相同的.
      3.2 Class类型的数组,此数组中只能放接口的Class对象.若代理对象不需要实现被代理对象已经实现的接口以外的接口,则可以使用
      3.3 InvocationHandler一般使用匿名内部类的方式,被代理对象的类型要求是final类型的.编译器会给出提示.
 */
    @Test
    public void testProxy(){
        //创建被代理的对象(接口类型)
        final CalcDao target = new CalcDaoImpl();
        //通过代理类Prxoy的newProxyInstance()方法创建代理对象
        CalcDao proxy = (CalcDao) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        System.out.println("方法【" + method.getName() + "】开始执行, 参数为" + Arrays.asList(args) + "...");
                        long start = System.currentTimeMillis();
                        Object result = method.invoke(target, args);
                        long end = System.currentTimeMillis();
                        System.out.println("方法【" + method.getName() + "】执行完成,运算结果为:" + result + ", 用时" + (end - start) + "毫秒!");
                        return result;
                    }
                });
        proxy.add(10, 2);
        proxy.sub(10, 2);
        proxy.mul(10, 2);
        proxy.div(10, 2);
    }

}