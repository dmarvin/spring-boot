package com.djm.springbootstart.foo.model;

import org.springframework.lang.Nullable;

public class Custom {

	public Custom() {
		this("");
	}

	public Custom(String id) {
		this.id = id;
	}


	@Nullable
	private String id;
	private String name;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
