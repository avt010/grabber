package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Pagination {
	
	private Integer total;
	
	private Integer limit;
	
	private Integer offset;
	
	public Pagination() {
		this.total = this.limit = this.offset = 0;
	}
	
	public Pagination(Integer total, Integer limit, Integer offset) {
		this.total = total;
		this.limit = limit;
		this.offset = offset;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public Integer getTotal() {
		return this.total;
	}
	
	public Integer getLimit() {
		return this.limit;
	}
	
	public Integer getOffset() {
		return this.offset;
	}
	
	@Override
	public String toString() {
		return "Pagination [total=" + total + ", limit=" + limit + ", offset=" + offset + "]";
	}
}
