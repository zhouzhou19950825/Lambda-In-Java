package com.upic.lanbdaSteam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.upic.po.User;

public class LambdaSteam {

	static List<User> list = Arrays.asList(new User("朱步青", 0L, 21), new User("董帅", 1L, 22), new User("董帅飞", 2L, 23),
			new User("张三", 3L, 30), new User("张飞", 4L, 50), new User("刘备", 5L, 53), new User("曹操", 6L, 75));

	public static void main(String[] args) {
		Stream<User> filter = list.stream().filter(it -> it.getAge() <=23);
		System.out.println("筛选年龄小于等于23岁的人");
		filter.forEach(result->System.out.println(result));
		
	}
}
