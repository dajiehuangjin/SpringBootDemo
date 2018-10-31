package com.wq.springboot.common.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/***
 * AJAX调用的通用JSON返回数据类型
 *  @author wq
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallResult {
	/***
	 * 操作成功与否
	 */
	private boolean success;
	
	/***
	 * 错误代码
	 */
	private int errorCode = 0;

	 /***
	 * 分页查询，用于显示总条数
	 */
	private Integer total = null;
	
	/***
	 * 服务器返回的文本信息，通常为null，可直接用于客户端显示。
	 */
	private String message = null;	
	
	/***
	 * 返回的数据纪录集
	 */
	private Object rows = null;
	
	/***
	 * 具体数据，依赖接口定义。
	 */
	private Object data = null;

    public CallResult(boolean success) {
		this.success = success;
		if(success)
			this.setErrorCode(0);
		else
			this.setErrorCode(-1);
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
		
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
		
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@SuppressWarnings("unchecked")
	public void addDataEntry(String key, Object value) {
		Map<String, Object> map;
		if(this.data == null) {
			map = new HashMap<String, Object>();
			this.data = map;
		}
		else {
			map = (Map<String, Object>)this.data;
		}
		map.put(key, value);
	}
}