package org.apache.dolphinscheduler.extract.base.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class ProxyMain implements InvocationHandler {

    private Object o;

    public ProxyMain(Object o) {
        this.o = o;
    }

    public static void main(String[] args) {

        UserSevice obj = new UserServiceImpl();

        ProxyMain proxyMain = new ProxyMain(obj);

        UserSevice userSevice = (UserSevice) Proxy.
                newProxyInstance(UserSevice.class.getClassLoader(), new Class[]{UserSevice.class}, proxyMain);

        userSevice.insert();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = method.invoke(o, args);
        invoke();
        return res;
    }


    private void invoke(){
        log.info("proxy invoke");
    }

}
