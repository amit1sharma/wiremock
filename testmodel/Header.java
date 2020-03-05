package com.amt.testmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"version","msg_id","msg_type","msg_function","src_application","target_application","timestamp","tracking_id","bank_id"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Header {
	
	private String version;
	private String msg_id;
	private String msg_type;
	
	
	private String msg_function;
	private String src_application;
	private String target_application;
	private String timestamp;
	private String tracking_id;
	private String bank_id;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getMsg_function() {
		return msg_function;
	}
	public void setMsg_function(String msg_function) {
		this.msg_function = msg_function;
	}
	public String getSrc_application() {
		return src_application;
	}
	public void setSrc_application(String src_application) {
		this.src_application = src_application;
	}
	public String getTarget_application() {
		return target_application;
	}
	public void setTarget_application(String target_application) {
		this.target_application = target_application;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTracking_id() {
		return tracking_id;
	}
	public void setTracking_id(String tracking_id) {
		this.tracking_id = tracking_id;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	
	
	
	
	
	
	

}
