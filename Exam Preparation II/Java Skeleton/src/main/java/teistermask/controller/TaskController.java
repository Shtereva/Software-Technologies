package teistermask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import teistermask.bindingModel.TaskBindingModel;
import teistermask.entity.Task;
import teistermask.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {
	private final TaskRepository taskRepository;

	@Autowired
	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Task> tasks = taskRepository.findAll();

		List<Task> openTasks = tasks.stream().filter(t -> t.getStatus().equals("Open")).collect(Collectors.toList());

		List<Task> inProgressTasks = tasks.stream().filter(t -> t.getStatus().equals("In Progress")).collect(Collectors.toList());

		List<Task> finishedTasks = tasks.stream().filter(t -> t.getStatus().equals("Finished")).collect(Collectors.toList());

		model.addAttribute("openTasks", openTasks);
		model.addAttribute("inProgressTasks", inProgressTasks);
		model.addAttribute("finishedTasks", finishedTasks);
		model.addAttribute("view", "task/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "task/create");
		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, TaskBindingModel taskBindingModel) {
		if (taskBindingModel == null || taskBindingModel.getTitle().equals("")) {
			return "redirect:/";
		}

		Task task = new Task(taskBindingModel.getTitle(), taskBindingModel.getStatus());
		taskRepository.saveAndFlush(task);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		if (!this.taskRepository.exists(id)) {
			return "redirect:/";
		}

		Task task = taskRepository.findOne(id);
		model.addAttribute("view", "task/edit");
		model.addAttribute("task", task);

		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, TaskBindingModel taskBindingModel) {
		if (!taskRepository.exists(id) || taskBindingModel == null || taskBindingModel.getTitle().equals("")) {
			return "redirect:/";
		}

		Task task = taskRepository.findOne(id);

		task.setStatus(taskBindingModel.getStatus());
		task.setTitle(taskBindingModel.getTitle());

		taskRepository.saveAndFlush(task);

		return "redirect:/";
	}
}
