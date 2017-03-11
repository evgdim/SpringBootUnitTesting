package com.github.evgdim.unittestig.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private Long id;
	private String name;
	private Short age;
}