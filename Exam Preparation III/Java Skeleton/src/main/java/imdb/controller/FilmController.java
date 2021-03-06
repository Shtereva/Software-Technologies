package imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import imdb.bindingModel.FilmBindingModel;
import imdb.entity.Film;
import imdb.repository.FilmRepository;

import java.util.List;

@Controller
public class FilmController {

	private final FilmRepository filmRepository;

	@Autowired
	public FilmController(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Film> films = this.filmRepository.findAll();

		model.addAttribute("view", "film/index");
		model.addAttribute("films", films);

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "film/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, FilmBindingModel filmBindingModel) {

		boolean hasEmptyFields = filmBindingModel == null
				|| filmBindingModel.getName().equals("")
				|| filmBindingModel.getGenre().equals("")
				|| filmBindingModel.getDirector().equals("")
				|| filmBindingModel.getYear() == null;

		if (!hasEmptyFields) {
			Film filmEntity = new Film(
					filmBindingModel.getName(),
					filmBindingModel.getGenre(),
					filmBindingModel.getDirector(),
					filmBindingModel.getYear()
			);

			this.filmRepository.saveAndFlush(filmEntity);
		}

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		Film film = filmRepository.findOne(id);

		if (this.filmRepository.exists(id) || film != null){
			model.addAttribute("view", "film/edit");
			model.addAttribute("film", film);

			return "base-layout";
		}
		return "redirect:/";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(Model model, @PathVariable int id, FilmBindingModel filmBindingModel) {
		Film film = this.filmRepository.findOne(id);


		boolean hasEmptyFields = filmBindingModel.getName().equals("")
				|| filmBindingModel.getGenre().equals("")
				|| filmBindingModel.getDirector().equals("")
				|| filmBindingModel.getYear() == null;

		if (this.filmRepository.exists(id) && !hasEmptyFields){
			film.setName(filmBindingModel.getName());
			film.setGenre(filmBindingModel.getGenre());
			film.setDirector(filmBindingModel.getDirector());
			film.setYear(filmBindingModel.getYear());

			this.filmRepository.saveAndFlush(film);

		}

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		if(this.filmRepository.exists(id)){
			Film film = this.filmRepository.findOne(id);

			model.addAttribute("view", "film/delete");
			model.addAttribute("film", film);

			return "base-layout";
		}
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {

		if(this.filmRepository.exists(id)){
			Film film = this.filmRepository.findOne(id);

			this.filmRepository.delete(film);
			//this.filmRepository.flush();
		}

		return "redirect:/";
	}
}
