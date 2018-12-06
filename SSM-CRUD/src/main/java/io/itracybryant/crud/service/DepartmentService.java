/**
 * 
 */
package io.itracybryant.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.itracybryant.crud.bean.Department;
import io.itracybryant.crud.dao.DepartmentMapper;

/**
 * @XinCheng 2018年9月1日 Administrator
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() {
		List<Department> list = departmentMapper.selectByExample(null);
		return list;
	}

}
