package com.upic.LambdaInterface;
/**
 * 
 * 函数式编程
 * @author DTZ
 *
 * @FunctionalInterface
	这个注解只是起文档的作用，说明这个接口是函数式接口，编译器并不会使用这个注解来决定一个接口是不是函数式接口。
	不管加不加@FunctionalInterface这个注解，下面的接口都是函数式接口： 
 */
@FunctionalInterface
public interface ILambda {

	public int add(int i,int j);
}
