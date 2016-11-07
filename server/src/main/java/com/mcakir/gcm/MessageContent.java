package com.mcakir.gcm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessageContent implements Serializable {

	private static final long serialVersionUID = 1L;

    @JsonProperty("registration_ids")
	private List<String> registrationIds;

    private Map<String, String> data;

    public List<String> getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(List<String> registrationIds) {
        this.registrationIds = registrationIds;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public void addData(String key, String value){
        if(this.data == null){
            this.data = new LinkedHashMap<String, String>();
        }

        if(key != null && !key.isEmpty() && value != null && !value.isEmpty()){
            this.data.put(key, value);
        }
    }

    @Override
	public String toString() {
		return "MessageContent [registration_ids=" + registrationIds
				+ ", data=" + data + "]";
	}
}
