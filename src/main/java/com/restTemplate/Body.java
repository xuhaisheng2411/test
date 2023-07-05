package com.restTemplate;

/**
 * 
 */

import java.io.Serializable;

/**
 * 为REST服务提供的统一的接口类
 * 
 * @author 李殿立
 *
 * 创建日期：2012-4-6
 * @version 1.0
 * @since 1.0
 */
public class Body<R, T> implements Serializable {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5184734087171929583L;

	/* 返回结果对象（如：Boolean String） */
	private R result;
	/* 需要传递的对象，可以是实体也可以是List等集合 */
	private T entiy;

	public Body() {
		super();
	}
	
	public Body(R result, T entiy) {
		super();
		this.result = result;
		this.entiy = entiy;
	}

	public R getResult() {
		return result;
	}

	public void setResult(R result) {
		this.result = result;
	}

	public T getEntiy() {
		return entiy;
	}

	public void setEntiy(T entiy) {
		this.entiy = entiy;
	}
	

}
