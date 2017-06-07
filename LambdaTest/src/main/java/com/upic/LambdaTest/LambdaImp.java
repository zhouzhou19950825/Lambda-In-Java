package com.upic.LambdaTest;

import com.upic.LambdaInterface.ILambda;

/**
 * 
 * @author DTZ
 *
 */
public class LambdaImp {

	public static void main(String[] args) {
		ILambda l=(i,j)->i+j;
		System.out.println(l.add(1, 2));
	}
}
