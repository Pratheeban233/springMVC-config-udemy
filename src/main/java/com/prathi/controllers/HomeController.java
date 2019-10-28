package com.prathi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prathi.model.Alien;

@Controller
public class HomeController 
{	
	@ModelAttribute
	public void modelData(Model name) 
	{
		name.addAttribute("Name","Prathi");
	}
	@RequestMapping("welcome")
	public String Home() 
	{
		//System.out.println("home controller requested");
		return "welcome"; 
	}
	@RequestMapping("addition")
	public String addition()
	{
		return "calculator";
		
	}
	
	
// 1. Using servelt and Session
	/*  @RequestMapping("add") 
	  public String add(HttpServletRequest req) 
	  { 
	  int i=Integer.parseInt(req.getParameter("num1")); 
	  int j=Integer.parseInt(req.getParameter("num2")); int k=i+j;
	  HttpSession session=req.getSession(); 
	  session.setAttribute("num3", k);
	  return "result.jsp"; 
	  } */
	 

// 2. RequestParam method
/*	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,HttpSession session)
	{	
		int k=i+j;
		session.setAttribute("num3", k);
		return "result.jsp"; 
	} */
	
// 3. ModelAndView (best way)
	/*@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j)
	{	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		
		//ModelAndView mv=new ModelAndView("result"); //(to avoid setViewName)
		int k=i+j;
		mv.addObject("num3", k);
		return mv; 
	}*/
	
// 4. using Model and ModelMap classes instead of ModelAndView
 /* @RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,Model m)
	//public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,ModelMap m) //for mapformat output
	{	
		int k=i+j;
		m.addAttribute("num3", k);
		return "result"; 
	}*/
	
/**************************************************************************************************/
// ModelAttributes
	
	/*@RequestMapping("addAlien")
	public String add(@RequestParam("aid") int aid,@RequestParam("aname") String aname, Model m)
	{
		Alien a=new Alien();
		a.setAid(aid);
		a.setAname(aname);
		
		m.addAttribute("alien", a);
		
		return "result"; 
	}*/
/*	@RequestMapping("addAlien")
	public ModelAndView add(@RequestParam("aid") int aid,@RequestParam("aname") String aname)
	{
		ModelAndView mv=new ModelAndView("result");
		Alien a=new Alien();
		a.setAid(aid);
		a.setAname(aname);
		
		mv.addObject("alien", a);
		
		return mv; 
	} */
	
/*****Model attribute******/
	
	/*@RequestMapping("addAlien")
	public ModelAndView add(@ModelAttribute ("a1") Alien a)
	//public ModelAndView add(@ModelAttribute ("a1") Alien a, Model m)
	{
		ModelAndView mv=new ModelAndView("result");
		//m.addAttribute("alien",a); return "result"; //another way
		mv.addObject("alien", a);
		
		return mv; 
	} */
	
	@RequestMapping(value="addAlien",method=RequestMethod.GET)
	 //@GetMapping("addAlien)
	public String add( @ModelAttribute Alien a)
	{
		return "result";
	}
	
/*	//@RequestMapping(value="addAlien",method=RequestMethod.POST)
	@PostMapping("addAlien")
	public String add( @ModelAttribute Alien a)
	{
		return "result";
	} */
	
}
