package com.yr.dao.oneToone;

import com.yr.entry.Classes;
import com.yr.entry.Teacher;

public interface ClassesMapper {
	
	
	
	public Classes getClass(Integer id);
		
	public Classes getClass2(Integer id);
	
	public Teacher getTeacher(Integer id);
	
	
}