package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Critaria {
	
	
	private int page;
	private String type;
	private String keyword;
	
	public Critaria() {
		this.page = 1;
	}
	
	public Critaria(int page) {
		this.page = page;
		
	}
	
	public String[] getArr() {
		
		if(this.type == null) {
			return null;
		}
		
		return this.type.split("");

	}
	
	public int getSkip() {
		
		if(this.page <= 0) {
			this.page = 1;
		}
		
		return (this.page - 1) * 10;
	}
	
	

}
