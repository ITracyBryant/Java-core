/**
 * 
 */
package io.itracybryant.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.itracybryant.crud.bean.Employee;
import io.itracybryant.crud.bean.Msg;
import io.itracybryant.crud.service.EmployeeService;

/**
 * 处理员工CRUD请求
 * @XinCheng 2018年8月31日 Administrator
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 员工信息删除方法，单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String id : str_ids) {
				del_ids.add(Integer.parseInt(id));
			}
			employeeService.deleteBatch(del_ids);
		}else{
			//单个删除
			Integer id =Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}	
		return Msg.success();
	}
	
	/**
	 * 如果直接发送ajax=PUT形式的请求，封装的数据Employee对象里全为null
	 * 
	 * question:请求体中有数据，但Employee对象封装不上
	 * 拼接的sql语句变为：update tbl_emp where emp_id=1014 语法错误，抛出异常
	 * 
	 * reason: Tomcat的问题：1.Tomcat将请求体中的数据封装成一个map；
	 * 					   2. request.getParameter("empName")就会从这个map中取值；
	 * 						3. SpringMVC封装POJO对象，会把POJO对象中每个属性的值，调用request.getParameter("email")
	 * 
	 * AJAX发送PUT请求的问题：
	 * 		PUT请求：请求体中的数据，request.getParameter("empName")拿不到
	 * 		Tomcat一看是PUT请求，就不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
	 * 
	 * Tomcat源码中 org.apache.catalina.connector.Request对象的parseParameters()
	 *  protected String parseBodyMethods = "POST";
	 *  
	 *  if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
        
       SpringMVC解决方案：
	 * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
	 * 1、配置上HttpPutFormContentFilter；
	 * 2、他的作用；将请求体中的数据解析包装成一个map。
	 * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
        
	 * 员工信息更新方法
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{empId}", method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee, HttpServletRequest request){
		System.out.println("请求体中的值：" + request.getParameter("gender"));
		System.out.println("要更新的员工数据：" + employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	
	/**
	 * 根据id查询员工
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id){
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * 检查用户名是否可用
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkUser(@RequestParam("empName")String empName){
		//先判断用户名是否合法表达式
		String regex = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regex)){
			return Msg.fail().add("va_msg", "用户名必须是6-16位数字字母组合或2-5位中文");
		}
		//校验数据库中用户名是否重复
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用户名不可用");
		}
	}
	
	/**
	 * 员工信息保存方法, 页面提交的请求的key-value中的key和employee对象的属性相同，自动封装Employee对象
	 * 重要数据必须进行后端校验
	 * 1.支持JSR-303校验
	 * 2.导入Hibernate-Validator
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee, BindingResult result){
		if(result.hasErrors()){
			//校验失败，返回失败信息，在模态框中显示后端校验失败的错误信息
			//将错误信息返回给浏览器显示
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名：" + fieldError.getField());
				System.out.println("错误信息：" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}		
	}
	
	/**
	 * 导入jackson包，将pageInfo对象转换成字符串
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn){
		// 这不是分页查询,根据pn算出开始查询的记录数，利用limit关键字改造getAll()
		// 引入PageHelper分页插件
		// 在查询之前只需调用startPage(),传入页码和分页每页数据
		PageHelper.startPage(pn, 5);
		// startPage后紧跟的查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 使用pageInfo包装查询后的结果，只需将pageInfo交给页面即可
		// pageInfo封装了详细的分页信息，包括查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 查询员工数据(分页查询)
	 * @return
	 */
	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model){
		
		//这不是分页查询,根据pn算出开始查询的记录数，利用limit关键字改造getAll()
		//引入PageHelper分页插件
		//在查询之前只需调用startPage(),传入页码和分页每页数据
		PageHelper.startPage(pn, 5);
		//startPage后紧跟的查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		//使用pageInfo包装查询后的结果，只需将pageInfo交给页面即可
		//pageInfo封装了详细的分页信息，包括查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		
		return "list";
	}

}
