/**
 * 
 */
package src.org.lhp.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO 
 * @Title : BackstageController.java
 * @author liheping 2012-4-16 上午10:35:30
 * @version : V1.0 2012-4-16 
 * @Copyright  : Copyright  ( c ) dev.liheping.org ,2012
 */
@Controller
@RequestMapping("/backstage/*")
public class BackstageController {
	@RequestMapping("login")
	public ModelAndView login(){
		return new ModelAndView("/base/login");
	}
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("/base/index");
	}
	@RequestMapping("left")
	public ModelAndView left(){
		return new ModelAndView("/base/left");
	}
	@RequestMapping("right")
	public ModelAndView right(){
		return new ModelAndView("/base/right");
	}
	@RequestMapping("top")
	public ModelAndView top(){
		return new ModelAndView("/base/top");
	}
}
