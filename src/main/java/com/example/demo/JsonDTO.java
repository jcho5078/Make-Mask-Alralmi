package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonDTO {
	@JsonProperty("count")
	public int count;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<storeInfos> getStoreInfos() {
		return storeInfos;
	}

	public void setStoreInfos(List<storeInfos> storeInfos) {
		this.storeInfos = storeInfos;
	}

	@JsonProperty("page")
	public String page;
	@JsonProperty("totalCount")
	public int totalCount;
	@JsonProperty("totalPages")
	public int totalPages;
	
	@JsonProperty("storeInfos")
	private List<storeInfos> storeInfos;
}
