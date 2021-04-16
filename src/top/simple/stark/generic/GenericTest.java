package top.simple.stark.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型测试类
 * @author Simple
 * @date 2020/12/22 17:36
 * @change: 2020/12/22 17:36 by Simple for init
 */
public class GenericTest {

    @Test
    public void Test1() {
        // 显而易见，编译时就会出现java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);
        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println("泛型测试,item = " + item);
        }
    }

    @Test
    public void Test2() {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println(classStringArrayList);
            System.out.println(classIntegerArrayList);
            System.out.println("泛型测试，类型相同");
        }
    }

    @Test
    public void Test3() {
        System.out.println();
    }

    public <T> T getEventDetails(Integer i) {
        return (T) i;
    }
}
