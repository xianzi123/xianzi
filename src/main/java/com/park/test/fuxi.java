package com.park.test;

import com.park.model.Puser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author hxy
 * @create 2025-3-09 23:05
 */
public class fuxi {
    int abc;
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("test3.txt"), "UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("test4.txt"), "UTF-8");
        int i;
        while ((i = inputStreamReader.read()) != -1) {
            System.out.println(i);
            outputStreamWriter.write(i);
        }
        outputStreamWriter.close();
        inputStreamReader.close();

//            File file = new File("test2.txt");
//            File
//            //建创文件夹
//            if (!file.getParentFile().exists()) {
//                file.getParentFile().mkdirs();
//            }
//            //建创文件
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//        System.out.println(file.getAbsoluteFile());
//        FileOutputStream fileOutputStream = new FileOutputStream("test3.txt");
////        FileOutputStream fileOutputStream = new FileOutputStream("ssmpark\\test.txt");
////        FileOutputStream fileOutputStream = new FileOutputStream("D:\\dl2376\\04_java服务器开发\\01_javaEE\\02_代码\\web-all\\ssmpark\\test.txt");
//
//        System.out.println(System.getProperty("user.dir"));
        //springboot建创puser对象
//        Puser puser = new Puser(11,"hxy","123","123","123","123");

//        Set<Puser> set = new HashSet<>();
//        ArrayList<Puser> list = new ArrayList<>();
//        HashMap<String,String> map = new HashMap<>();
//        map.put("a","b");
//        map.put("c","d");
//        map.entrySet().stream().forEach(System.out::println);
////        File file = new File("D:\\test.txt");
//        String[] strings = new String[]{"a","b","c"};
//        System.out.println(strings);
//
////        Map<String,String> map = Map.of("a","b","c","d");
//        set.add(puser);
//        System.out.println(set.add(puser));
//        set.forEach(s -> {
//            System.out.println(s);
//        });
//        int ac;
//        ac =3;
//        int c =500;

//            Math.random();
//            Random random = new Random();
//            for (int i = 0; i < 100; i++){
//                int a =random.nextInt(100);
//                int b =random.nextInt(100);
//            int bb =a&b;
//
//            System.out.println(a+"&"+b+"="+bb);
//            }
//        System.out.println(Objects.equals(a, b));
//        System.out.println(a.equals(b));
//        String s = new String("hello");
//        String s1 = new String("hello");
//        Runtime  runtime = Runtime.getRuntime();
//        ZoneId.getAvailableZoneIds();
//        System.out.println(s.equals(s1));
//        System.out.println(runtime.availableProcessors());
//        System.out.println(runtime.maxMemory()/1024/1024/1024);
//        System.out.println(Objects.equals(s, s1));
//        System.out.println(s.equals(s1));
//        System.out.println(runtime.exec("notepad"));
//        LocalDate now = LocalDate.now();
////        System.out.println(now);
//
//        LocalDate localDate = LocalDate.of(2025, 3, 9);
//        System.out.println(localDate);
//        System.out.println(localDate.getMonthValue());
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(ChronoUnit.DAYS.between(now, localDate));




    }
}
class Animal implements Callable<Integer> {
    public void eat(){
        System.out.println("Animal eat");
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
class Dog extends Animal{

}
class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("Cat eat");
    }
}
