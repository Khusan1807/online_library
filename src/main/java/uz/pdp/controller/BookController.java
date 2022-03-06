package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookUpdateDto;
import uz.pdp.service.BookService;

@Controller
@RequestMapping("/book/*")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "book/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute BookCreateDto dto) {
        service.create(dto);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("books", service.getAll());
        return "book/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("book", service.get(id));
        return "book/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute BookUpdateDto dto) {
        dto.setId(id);
        service.update(dto);
        return "redirect:/book/list";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("book", service.get(id));
        return "book/delete";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute Long id) {
        service.delete(id);
        return "redirect:/book/list";
    }


}
