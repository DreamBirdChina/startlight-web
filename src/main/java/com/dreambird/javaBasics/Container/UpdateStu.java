package com.dreambird.javaBasics.Container;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.applet.Main;
import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created by chen.jun on 2018/2/17.
 */
public class UpdateStu implements Comparable<Object> {

    Long id;

    String name;

    public UpdateStu(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        UpdateStu updateStu = (UpdateStu) o;
        int result = id.longValue()>updateStu.getId().longValue() ? 1 : (id.longValue() == updateStu.getId().longValue() ? 0:-1);
        return result;
    }

    public static void main(String[] args){
        UpdateStu stu1 = new UpdateStu(1001L,"����");
        UpdateStu stu2 = new UpdateStu(1002L,"����");
        UpdateStu stu3 = new UpdateStu(1000L,"����");
        UpdateStu stu4 = new UpdateStu(1003L,"����");

        TreeSet<UpdateStu> treeSet = new TreeSet<UpdateStu>();
        treeSet.add(stu1);
        treeSet.add(stu2);
        treeSet.add(stu3);
        treeSet.add(stu4);
        System.out.println("����TreeSet���Ͽ�ʼ----------");
        Iterator<UpdateStu> it = treeSet.iterator();
        while (it.hasNext()){
            UpdateStu stu = it.next();
            System.out.println(stu.getId()+"---------"+stu.getName());
        }
        System.out.println("��ȡǰ�沿�ֵļ��ϣ�");
        it = treeSet.headSet(stu2).iterator();
        while (it.hasNext()){
            UpdateStu stu = it.next();
            System.out.println(stu.getId()+"---------"+stu.getName());
        }
        it = treeSet.subSet(stu3,stu4).iterator();
        System.out.println("��ȡ�м䲿�ֵļ���");
        while (it.hasNext()){
            UpdateStu stu = it.next();
            System.out.println(stu.getId()+"---------"+stu.getName());
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("01","����");
        map.put("02","����");
        map.put("03","����");
        Set<String> keys = map.keySet();
        for(String str:keys){
            System.out.println(map.get(str));
        }

        Collection<Object> values = map.values();
        Iterator<Object> its = values.iterator();
        while (its.hasNext())
            System.out.println(its.next());
    }
}
