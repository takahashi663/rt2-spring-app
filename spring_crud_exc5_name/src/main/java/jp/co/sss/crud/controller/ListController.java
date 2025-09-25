package jp.co.sss.crud.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.service.SearchAllEmployeesService;
import jp.co.sss.crud.service.SearchForEmployeeByAddressService;
import jp.co.sss.crud.service.SearchForEmployeeByAuthorityService;
import jp.co.sss.crud.service.SearchForEmployeesByDepartmentService;
import jp.co.sss.crud.service.SearchForEmployeesByEmpIdService;
import jp.co.sss.crud.service.SearchForEmployeesByEmpNameService;

@Controller
public class ListController {

	@Autowired
	SearchAllEmployeesService searchAllEmployeesService;

	@Autowired
	SearchForEmployeesByEmpNameService searchForEmployeesByEmpNameService;

	@Autowired
	SearchForEmployeesByDepartmentService searchForEmployeesByDepartmentService;
	
	@Autowired
	SearchForEmployeeByAuthorityService searchForEmployeeByAuthorityService;
	
	@Autowired
	SearchForEmployeeByAddressService searchForEmployeeByAddressService;
	
	@Autowired
	SearchForEmployeesByEmpIdService searchForEmployeesByEmpIdService;
	/**
	 * 社員情報を全件検索した結果を出力
	 *
	 * @param model モデル
	 * @return 遷移先のビュー
	 * @throws ParseException 
	 */
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String findAll(Model model) {

		List<EmployeeBean> allEmployeeList = null;
		//TODO SearchAllEmployeesService完成後にコメントを外す
				allEmployeeList = searchAllEmployeesService.execute();

		model.addAttribute("employees", allEmployeeList);
		return "list/list";
	}

	/**
	 * 社員情報を社員名検索した結果を出力
	 *
	 * @param empName 検索対象の社員名
	 * @param model モデル
	 * @return 遷移先のビュー
	 * @throws ParseException 
	 */
	//社員名検索
	@RequestMapping(path = "/list/empName", method = RequestMethod.GET)
	public String findByEmpName(String empName, Model model) {

		List<EmployeeBean> searchByEmpNameList = null;

		//TODO SearchForEmployeesByEmpNameService完成後にコメントを外す
				searchByEmpNameList = searchForEmployeesByEmpNameService.execute(empName);

		model.addAttribute("employees", searchByEmpNameList);
		return "list/list";
	}

	/**
	 * 社員情報を部署ID検索した結果を出力
	 *
	 * @param deptId 検索対象の部署ID
	 * @param model モデル
	 * @return 選先のビュー
	 * @throws ParseException 
	 */
	//部署名検索
	@RequestMapping(path = "/list/deptId", method = RequestMethod.GET)
	public String findByDeptId(Integer deptId, Model model) {

		

		//TODO SearchForEmployeesByDepartmentService完成後にコメントを外す
		List<EmployeeBean> searchByDepartmentList = searchForEmployeesByDepartmentService.execute(deptId);

		model.addAttribute("employees", searchByDepartmentList);
		return "list/list";
	}
	//権限検索
	@RequestMapping(path = "/list/authority", method = RequestMethod.GET)
	public String findByAuthority(Integer authority, Model model) {

		List<EmployeeBean> searchByAuthorityList = searchForEmployeeByAuthorityService.execute(authority);
		model.addAttribute("employees", searchByAuthorityList);
		return "list/list";
	}
	//住所検索
	@RequestMapping(path = "/list/address", method = RequestMethod.GET)
	public String findByAddress(String address, Model model) {

		List<EmployeeBean> allEmployeeList = null;
		
				allEmployeeList = searchForEmployeeByAddressService.execute(address);

		model.addAttribute("employees", allEmployeeList);
		return "list/list";
	}

}
