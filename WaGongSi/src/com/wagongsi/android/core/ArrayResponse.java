package com.wagongsi.android.core;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.wagongsi.android.bean.CompanyInfoBean;
import com.wagongsi.android.bean.LinkBean;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrayResponse {
	
	private ArrayList<CompanyInfoBean> items;
	
	private ArrayList<LinkBean> links;
	

	public ArrayList<CompanyInfoBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<CompanyInfoBean> items) {
		this.items = items;
	}

	public ArrayList<LinkBean> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<LinkBean> links) {
		this.links = links;
	}
	
	

}
