package com.company;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] Args)
    {
        TestEverything();
    }
    public static void TestEverything()
    {
        for (Method method : Main.class.getMethods())
        {
            if(method.isAnnotationPresent(Test.class))
            {
                try
                {
                    var annotation = method.getAnnotation(Test.class);
                    method.invoke(new Main(), annotation.a(), annotation.b());
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        }
    }
    @Test(a=2,b=5)
    public void test(int a, int b)
    {
        int res = a+b;
        System.out.println("Result " + res);
    }
}
