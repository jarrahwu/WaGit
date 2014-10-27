package com.wagongsi.android.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyInfoBean implements Serializable{

	private static final long serialVersionUID = 1088269943697244958L;
	
	@JsonProperty(value = "CompanyName")
	private String companyName;
	
	@JsonProperty(value = "CompanyDesc")
	private  String projectDescription;
	
	@JsonProperty(value = "CompanyBody")
	private String dreamingBackground;
	
	@JsonProperty(value = "CommentNum")
	private int commentCount;
	
	@JsonProperty(value = "DingNum")
	private int likeCount;
	
	@JsonProperty(value = "CommentUrl")
	private String commentUri;
	
	@JsonProperty(value = "ShareUrl")
	private String shareUri;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getDreamingBackground() {
		return dreamingBackground;
	}

	public void setDreamingBackground(String dreamingBackground) {
		this.dreamingBackground = dreamingBackground;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getCommentUri() {
		return commentUri;
	}

	public void setCommentUri(String commentUri) {
		this.commentUri = commentUri;
	}
}
