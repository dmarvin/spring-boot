package com.djm.springbootstart.foo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7301027271198767693L;
	private String name;
	private String password;

}
