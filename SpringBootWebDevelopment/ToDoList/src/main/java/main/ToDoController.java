package main;

import main.model.Course;
import main.model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/courses")
public class ToDoController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping()
    public String coursesList(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String addCourse(Model model){
        model.addAttribute("course", new Course());
        return "new";
    }

    @PostMapping()
    public String createCourse(@ModelAttribute("course") @Valid Course course,
    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        courseRepository.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "show";
    }

    @DeleteMapping("/{id}")
    public String removeCourse(@ModelAttribute("course") Course course, @PathVariable int id) {
        courseRepository.deleteById(id);
        return "redirect:/courses";
    }

    @DeleteMapping("")
    public String removeAllCourses() {
        courseRepository.deleteAll();
        return "index";
    }

    @GetMapping("/{id}/edit")
    public String editorCourse(@PathVariable int id, Model model){
        model.addAttribute("course", courseRepository.findById(id).get());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editCourse(@ModelAttribute("course") @Valid Course course,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        courseRepository.save(course);
        return "redirect:/courses";
    }
}
