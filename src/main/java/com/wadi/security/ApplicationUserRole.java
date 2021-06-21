package com.wadi.security;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
	
	
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,ApplicationUserPermission.COURSE_WRITE,
			ApplicationUserPermission.STUDENT_READ, ApplicationUserPermission.COURSE_WRITE)),
	ADMINTRANEE(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,ApplicationUserPermission.STUDENT_READ ));

	
	private final Set<ApplicationUserPermission> persmission;

	private ApplicationUserRole(Set<ApplicationUserPermission> persmission) {
		this.persmission = persmission;
	}

	public Set<ApplicationUserPermission> getPersmission() {
		return persmission;
	}
}
