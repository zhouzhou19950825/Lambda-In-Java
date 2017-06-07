package com.upic.lanbdaSteam;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.upic.po.User;

public class PredicateFilter {
	public enum Position{
		STUDENT,PROGRAMMER,SOLDIER
	}
	static List<User> list = Arrays.asList(new User("朱步青", 0L, 21,Position.STUDENT.toString()), 
			new User("董帅", 1L, 22,Position.PROGRAMMER.toString()), new User("董帅飞", 2L, 23,Position.STUDENT.toString()),
			new User("张三", 3L, 30,Position.SOLDIER.toString()), new User("张飞", 4L, 50,Position.SOLDIER.toString()),
			new User("刘备", 5L, 53,Position.SOLDIER.toString()), new User("曹操", 6L, 75,Position.SOLDIER.toString()));
	public static void main(String[] args) {
		//准备条件
		Predicate<User> ageFilter = (p) -> (p.getAge() > 50);
		Predicate<User> positionFilter = (p) ->( p.getPosition().equals(Position.SOLDIER.toString()));
		
		System.out.println("下面是年龄大于 50岁且是个战士");
		Stream<User> filter = list.stream().filter(ageFilter).filter(positionFilter);
		filter.forEach(p->System.out.println(p));
		
		System.out.println("========================================================================");
		//也可以limit结果数量
		System.out.println("满足条件后只要一个结果");
		Stream<User> filterLimit = list.stream().filter(ageFilter).filter(positionFilter).limit(1);
		filterLimit.forEach(p->System.out.println(p));
		
		//可以做排序
		list.stream().filter(ageFilter).filter(positionFilter).sorted((p1,p2)->(p1.getAge()-p2.getAge()));
	}
}
