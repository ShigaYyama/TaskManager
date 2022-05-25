package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Knowledge;
import com.example.demo.model.TakeOverTask;
import com.example.demo.model.User;
import com.example.demo.repository.KnowledgeRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TaskController {

	private final UserRepository userRepository;
	private final TaskRepository taskRepository;
	private final KnowledgeRepository knowledgeRepository;
	
//	@Autowired
//	public TaskController(TaskRepository repository) {
//		this.repository = repository;
//	}
	
	@GetMapping("/")
    public String index(Model model) {
        return "login";
	}

	@PostMapping("/")
	public String confirm(@Validated @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors()){
			return "error";
		}
		return "login";
	}	

	@GetMapping("/users")
	public String user(Model model) {
		List<User>userLoad = getUserAll();
		model.addAttribute("userLoad", userLoad);
		return "users";
	}		
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}	
	
	@GetMapping("/selectAllTask")
	public String selectAllTask(Model model) {
		List<TakeOverTask>taskLoad = getTaskAll();
		model.addAttribute("taskLoad", taskLoad);
		return "takeovertask";
	}
	
	@GetMapping("/memo")
    public String memo(Model model) {
		model.addAttribute("takeOverTask", new TakeOverTask());
		return "writingmemo";
	}

    @PostMapping("/addmemo")
    public String addComment(@Validated @ModelAttribute TakeOverTask takeOverTask,
            BindingResult result, Model model) {
    	
    	Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

		takeOverTask.setCreateDate(ts);
		takeOverTask.setLatestUpdateDate(ts);
    		
        model.addAttribute("findTask", taskRepository.findAll());
        if (result.hasErrors()) {
            return "error";
        }
        taskRepository.save(takeOverTask);

        return "redirect:/memo";
    }		

	@GetMapping("/taskconfirm")
    public String taskconfirm(Model model) {
        return "taskconfirm";
	}    
    
	@GetMapping("/knowledge")
    public String knowledge(Model model) {
		List<Knowledge>knowledgeLoad = getKnowledgeAll();
		model.addAttribute("knowledgeLoad", knowledgeLoad);
        return "knowledge";
	}

	@GetMapping("/serchtask")
    public String serchTask() {
		return "serchtask";
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

	private List<User> getUserAll() {
	    //全件取得
	    return userRepository.findAll();
	}    
    
	private List<TakeOverTask> getTaskAll() {
	    //全件取得
	    return taskRepository.findAll();
	}
	
	private List<Knowledge> getKnowledgeAll() {
	    //全件取得
	    return knowledgeRepository.findAll();
	}
	
	private TakeOverTask getById(Integer takeOverId) {
	    //IDで検索
	    return taskRepository.findById(takeOverId).orElseThrow();
	}	
	
}
