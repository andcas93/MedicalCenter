package com.rm3.dao;

import org.apache.catalina.User;

import com.rm3.model.Utente;


public interface UserDao {
	public Utente getUser(Integer id);
}

