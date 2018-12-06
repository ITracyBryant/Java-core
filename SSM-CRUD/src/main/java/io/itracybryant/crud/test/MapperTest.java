package io.itracybryant.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.itracybryant.crud.bean.Employee;
import io.itracybryant.crud.dao.DepartmentMapper;
import io.itracybryant.crud.dao.EmployeeMapper;

/*
 * 测试DAO层
 * 推荐写法：Spring的项目可以使用Spring的单元测试，可以自动注入需要的组件
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直接@Autowired需要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	SqlSession sqlSession;

	/*
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD() {
		/*
		 * //传统测试写法 //根据配置文件创建SpringIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * //从容器中获取Mapper ioc.getBean(DepartmentMapper.class);
		 */
		System.out.println(departmentMapper);

		// 1.插入几个部门
		/*
		 * departmentMapper.insertSelective(new Department(null, "开发部"));
		 * departmentMapper.insertSelective(new Department(null, "测试部"));
		 */
		// 2.生成员工数据，测试员工插入

		/*
		 * employeeMapper.insertSelective(new Employee(null, "itracybryant",
		 * "M", "itracybryant@cx.com", 1));
		 */

		// 3.批量插入多个员工，使用可以执行批量操作的sqlSession
		/*
		 * for() { employeeMapper.insertSelective(new Employee(null, "UserID",
		 * "M", "itracybryant@cx.com", 1)); }
		 */

		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insertSelective(new Employee(null, uid, "M", uid + "@163.com", 1));
		}
		System.out.println("批量插入完成！");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
