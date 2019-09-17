package my.project.task2.controller;

import my.project.task2.model.Folder;
import my.project.task2.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FolderController {
    @Autowired
    FolderService folderService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("parent", folderService.getParent());
        if (folderService.getParent().isEmpty()) {
            model.addAttribute("no_direct", "No directories yet");
        }
        model.addAttribute("parent_id", 0L);
        return "index";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addPage(@PathVariable("id") Long parent_id, @ModelAttribute("folder") Folder folder, ModelMap model) {
        model.addAttribute("parent_id", parent_id);
        return "add";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Folder folder) {
        folderService.add(folder);
        return "redirect:/";
    }



    @RequestMapping(value = "/getFolder/{parent_id}", method = RequestMethod.GET)
    public String getFolder(@PathVariable("parent_id") Long id, ModelMap model) {
        model.addAttribute("child", folderService.getChild(id));
        model.addAttribute("id", id);
        return "folder";
    }




    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model model) {
        folderService.delete(id);
        model.addAttribute("success", "folder deleted successfully");
        return "redirect:/";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("folderList", folderService.getAll());
        return "edit";
    }

    @RequestMapping(value = "/moveOn/{id}/{folder_id}", method = RequestMethod.GET)
    public String moveFolder(@PathVariable("id") Long id, @PathVariable("folder_id") Long folder_id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("folder_id", folder_id);
        model.addAttribute("folderList", folderService.getAll());
        folderService.move(id,folder_id);
        return "redirect:/";
    }

}


