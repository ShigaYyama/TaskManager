package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.TakeOverTask;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TaskController {
   
	private final TaskRepository repository;
	
//	@Autowired
//	public TaskController(TaskRepository repository) {
//		this.repository = repository;
//	}
	
	@GetMapping("/")
    public String index(Model model) {
        return "login";
	}
	
	@GetMapping("/test")
	public String task(Model model) {
		return "takeovertask";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
	@PostMapping("/")
	public String confirm(@Validated @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors()){
			return "error";
		}
		return "login";
	}
	
//	@GetMapping("/show")
//	public String showList(Model model) {
//		Optional<TakeOverTask> test = repository.findById(3);
//		model.addAttribute("task", test);
//		List<TakeOverTask>test2 = repository.findAll();
//		model.addAttribute("taskAll", test2);
//		return "takeovertask";
//	}
//	
//	@PostMapping("/login")
//	public String login(@ModelAttribute TakeOverTask takeovertask) {
//		return "takeovertask";
//	}
	
	@GetMapping
	public List<TakeOverTask> getAll() {
	    //全件取得
	    return repository.findAll();
	}
	
    @GetMapping("{id}")
	public TakeOverTask getById(@PathVariable("id") Integer takeOverId) {
	    //IDで検索
	    return repository.findById(takeOverId).orElseThrow();
	}	
	
}
