package com.wadi.security;

public enum ApplicationUserPermission {

	STUDENT_READ("student:read"),
	STUDENT_WRITE("studen:write"),
	COURSE_READ("cours:read"),
	COURSE_WRITE("cours:write");
	
	private final String persmission;

	private ApplicationUserPermission(String persmission) {
		this.persmission = persmission;
	}

	public String getPersmission() {
		return persmission;
	}
}
