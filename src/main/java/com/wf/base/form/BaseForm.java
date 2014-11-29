package com.wf.base.form;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wf.base.action.BaseAction;

public class BaseForm extends BaseAction {
	
	public JSONObject jsonData = new JSONObject(); //返回的json对象
	public JSONArray jsonArray = new JSONArray(); //返回的数组集合形式的json对象
	
	// dataMap中的数据将会被Struts2转换成JSON字符串
	public Map<Object, Object> jsondataMap = new HashMap<Object, Object>(); //返回的json对象
	
	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	
	public Map<Object, Object> getJsondataMap() {
		return jsondataMap;
	}
	public void setJsondataMap(Map<Object, Object> jsondataMap) {
		this.jsondataMap = jsondataMap;
	}
	
}
