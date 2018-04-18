package com.plf.manage.dao;

import com.plf.manage.domain.Manage;

public interface ManageDao {

	public Manage findByUnAndPw(String username, String password);
}
