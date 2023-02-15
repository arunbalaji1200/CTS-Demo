package com.cts.gsd.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gsd.model.NewLaptop;
import com.cts.gsd.model.RepairLaptop;
import com.cts.gsd.model.RequestForm;
import com.cts.gsd.model.RequestForm.Status;
import com.cts.gsd.model.Role;
import com.cts.gsd.model.User;
import com.cts.gsd.user.FormService;
import com.cts.gsd.user.RoleService;
import com.cts.gsd.user.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class GsdController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FormService formService;
	
	@PostMapping(path="adduser/{id}", consumes= {"application/json"})
	public User adduser(@PathVariable("id") int id,@RequestBody User user) {
		userService.addUser(id, user);	
		return user;
	}
	
	@GetMapping("getuser")
	public List<User> getuser() {
		return userService.getUser();
	}
	
	@GetMapping("getiduser/{id}")
	public Optional<User> getuserid(@PathVariable int id) {
		return userService.getUserId(id);
	}
	
	@PatchMapping("updateuser/{id}")
	public User updateuser(@PathVariable int id,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("deleteuser/{id}")
	public void deleteuser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}
	@PostMapping("addrole/{id}")
	public Role addrole(@PathVariable("id")int id,@RequestBody Role role){
		return roleService.addRole(id,role);		
	}
	
	@GetMapping("getrole")
	public List<Role> getrole() {
		return roleService.getRole();
	}
	
	@GetMapping("getidrole/{id}")
	public Optional<Role> getroleid(@PathVariable int id) {
		return roleService.getRoleId(id);
	}
	
	@PatchMapping("updaterole/{id}")
	public Role updaterole(@PathVariable("id")int id,@RequestBody Role role) {
		return roleService.updateRole(id, role);
	}
	
	@DeleteMapping("deleterole/{id}")
	public void deleterole(@PathVariable("id") int id) {
		roleService.deleteRole(id);
	}
	
//	@GetMapping("getform")
//	public ResponseEntity<Pagenation> showform
//			(@RequestParam(value="pageNo",defaultValue ="0",required = false) int pageNo,
//			@RequestParam(value="pageSize",defaultValue ="3",required = false) int pageSize,
//			@PathVariable(value="sortField",required=false) String sortField)
//	{
//		return new ResponseEntity<Pagenation>(formService.showform(pageNo,pageSize, "id","desc"),HttpStatus.OK);
//	}
//	@CrossOrigin(origins="http://localhost:3000/viewform")
	@GetMapping("getform")
	public Map<String, Object> findPaginated(
			@RequestParam(value="pageNo",required = false) int pageNo,
			@RequestParam(value="pageSize",required = false) int pageSize) {
		return formService.findPaginated(pageNo, pageSize);
	}
	
	@PostMapping("saveform")
	public RequestForm addform(@RequestBody RequestForm requestform) {
		return formService.addform(requestform);
	}
	
	@GetMapping("getnewlap")
	public List<NewLaptop> shownewlap() {
		return formService.shownewlap();
	}
	
	@GetMapping("getnewid/{id}")
	public Optional<NewLaptop> shownewid(@PathVariable("id")int id){
		return formService.shownewid(id);
	}
	
	@GetMapping("getrepairid/{id}")
	public Optional<RepairLaptop> showrepairid(@PathVariable("id")int id) {
		return formService.showrepairid(id);
	}
	
//	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="update/status/{id}")
	public Status updatestatus(@PathVariable("id") int id,@RequestBody Status status) {
		 return formService.updatestatus(id,status);
	}
	
	@PostMapping("update/comment/{id}")
		public void updatecomment(@PathVariable("id")int id,@RequestBody String comments) {
			formService.updatecomment(id, comments);
		}
}
