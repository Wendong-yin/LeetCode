package Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashIterate {
    public static void main(String[] args) {
        Map<String, Integer> score = new HashMap<>();
        score.put("语文",90);
        score.put("语文",100);
        score.put("数学",94);
        score.put("物理",65);
        score.put("生物",21);
        score.put("历史",99);
        score.put("化学",88);

        ////////////////////////////////
        System.out.println("1.只遍历key");
        //直接输入iter，选XXX.keySet()
        for (String s : score.keySet()) {
            System.out.println(s);
        }

        ////////////////////////////////
        System.out.println("2.1 遍历values");
        //直接输入iter，选XXX.values()
        for (Integer s : score.values()) {
            System.out.println(s);
        }
        ////////////////////////////////


        ////////////////////////////////
        System.out.println("2.2 间接通过get遍历values");
        for (String s : score.keySet()) {
            System.out.println(score.get(s));
        }
        ////////////////////////////////


        ////////////////////////////////
        System.out.println("3.遍历key和values");
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        ////////////////////////////////


        ////////////////////////////////
        System.out.println("4. 创建一个临时的set");
        // 先输入score.entrySet()，然后option+command+v
        Set<Map.Entry<String, Integer>> entries = score.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey()+":");
            System.out.println(entry.getValue());
        }
        ////////////////////////////////


        ////////////////////////////////
        System.out.println("5.用Iterator");
        Iterator<Map.Entry<String, Integer>> iterator = score.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey()+":" + entry.getValue());
        }
        ////////////////////////////////



    }
}
