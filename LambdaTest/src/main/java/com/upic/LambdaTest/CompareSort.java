package com.upic.LambdaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.upic.po.User;
/**
 * 
 * @author DTZ
 *
 */
public class CompareSort {
	static List<User> list = Arrays.asList(new User("朱步青", 0L, 21), new User("董帅", 1L, 22), new User("董帅飞", 2L, 23),
			new User("张三", 3L, 30), new User("张飞", 4L, 50), new User("刘备", 5L, 53), new User("曹操", 6L, 75));

	public static void main(String[] args) {
		// Collections.sort(list, new Comparator<User>() {
		// public int compare(User x, User y) {
		// return x.getUserName().compareTo(y.getUserName());
		// }
		// });

		// 使用lambda表达式写法：
		//顺序打乱
		Collections.shuffle(list);
		list.forEach(it->System.out.println("排序前:"+it));
		list.sort(Comparator.comparing(User::getAge));
		System.out.println("====================================================");
		list.forEach(it->System.out.println("排序后"+it));
	}
}
