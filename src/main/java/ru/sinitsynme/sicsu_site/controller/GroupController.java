package ru.sinitsynme.sicsu_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sinitsynme.sicsu_site.entity.Group;
import ru.sinitsynme.sicsu_site.service.GroupService;
import ru.sinitsynme.sicsu_site.entity.StudentData;
import ru.sinitsynme.sicsu_site.service.StudentDataService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final StudentDataService studentDataService;

    @Autowired
    public GroupController(GroupService groupService,
                           StudentDataService studentDataService) {
        this.groupService = groupService;
        this.studentDataService = studentDataService;
    }

    @GetMapping
    public String getGroupList(Model model) { //add String filter by first letters
        List<Group> groupList = groupService.getAllGroups();
        model.addAttribute("groups", groupList);

        return "/group/groupList";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/new")
    public String getGroupRegisterForm() {
        return "/group/groupAdd";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/new")
    public String addGroup(Model model, Group group) {
        if (groupService.getByGroupFullId(group.getGroupFullId()) != null) {
            model.addAttribute("message", "Group with the same id is already present!");
            return "/group/groupAdd";
        }
        groupService.saveGroup(group);
        return "redirect:/groups";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/edit")
    public String getEditForm(@PathVariable Long id, Model model) {
        Optional<Group> group = groupService.getGroupById(id);
        if (group.isPresent()) {
            model.addAttribute("group", group.get());
            return "/group/groupAdd";

        }
        model.addAttribute("error", "Cannot find such group");
        return "utilPages/errorPage";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/{id}")
    public String editGroup(Group group) {
        groupService.saveGroup(group);
        return "redirect:/groups";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupService.deleteByGroupId(id);
        return "redirect:/groups";
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_TEACHER')")
    @GetMapping("/{id}/students")
    public String viewStudentsByGroup(@PathVariable Long id, Model model) {
        List<StudentData> students = studentDataService.getStudentsByGroup(id);
        Optional<Group> optionalGroup = groupService.getGroupById(id);

        if (optionalGroup.isEmpty()) {
            model.addAttribute("error", "Something went wrong!");
            return "/utilPages/errorPage";
        }

        model.addAttribute("group", optionalGroup.get());

        if (students.size() == 0) {
            model.addAttribute("message", "There are no students in this group!");
            return "/group/studentList";
        }

        model.addAttribute("students", students);
        return "/group/studentList";
    }


}
