package br.com.api.domain;

import java.util.stream.Stream;

public enum AuthorityEnum {
	
	ROLE_SYSTEMADMIN(1), 
	ROLE_MANAGER(2),
	ROLE_USER(3);
	
	private Integer id;

	private AuthorityEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public static AuthorityEnum findById(Integer id) {
		return Stream.of(AuthorityEnum.values())
			.filter(i -> i.equals(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}

}
