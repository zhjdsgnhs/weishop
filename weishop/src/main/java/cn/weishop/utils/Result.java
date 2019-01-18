package cn.weishop.utils;

/**
 * 数据返回类
 *
 * @author ASUS
 */

public class Result {

	/**
	 * 返回请求是否成功
	 */
	private boolean success;

	/**
	 * 返回状态码
	 */
	private Integer code;

	/**
	 * 返回报错描述
	 */
	private String message;

	/**
	 * 返回响应的数据
	 */
	private Object data;

	public Result() {

	}

	public Result(boolean success, Integer code, String message, Object data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result(boolean success, Integer code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
