package com.drs.mes.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args){
        Map<String,Object> one = new HashMap<>();
        one.put("id","001");
        one.put("id1","1");
        one.put("name","曹操");
        one.put("sex","1234");
        Map<String,Object> one2 = new HashMap<>();
        one2.put("id","002");
        one2.put("id1","2");
        one2.put("name","孙权");
        one2.put("sex","234");
        Map<String,Object> one3 = new HashMap<>();
        one3.put("id","003");
        one3.put("id1","3");
        one3.put("name","刘备");
        one3.put("sex","345");
        List<Map<String,Object>> listA = new ArrayList<>();
        listA.add(one);
        listA.add(one2);
        listA.add(one3);

        Map<String,Object> two = new HashMap<>();
        two.put("id","001");
        two.put("添加","2");
        Map<String,Object> two2 = new HashMap<>();
        two2.put("id","002");
        two2.put("sex",31);
        Map<String,Object> two3 = new HashMap<>();
        two3.put("id","004");
        two3.put("name","李四");
        two3.put("sex","345");
        List<Map<String,Object>> listB = new ArrayList<>();
        listB.add(two);
        listB.add(two2);
        listB.add(two3);

        // 合并
        listB.addAll(listA);
        listB.forEach(System.out::println);
        //去重
        List<Map<String,Object>> result = listB.stream()
                .collect(Collectors.groupingBy(group -> group.get("id").toString()))//根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
                .entrySet()//得到Set<Map.Entry<String, List<Map<String, Object>>>
                .stream()
                .map(map -> {
                    Map<String,Object> collect = map.getValue().stream()//m.getValue()的结果是 List<Map<String, Object>>
                            .flatMap(o -> o.entrySet().stream())//o.entrySet() 的结果是 Set<Map.Entry<String, Object>>
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(m1,m2) -> m2));//(m1, m2) -> m2 的意思是如果 m1 == m2 则使用m2
                    return collect;
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
