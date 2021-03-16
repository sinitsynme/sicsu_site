package ru.sinitsynme.sicsu_site.group.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.group.entity.Group;
import ru.sinitsynme.sicsu_site.group.service.GroupService;

@Controller
@RequestMapping("/groups")
public class GroupController {

  private final GroupService groupService;

  @Autowired
  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @GetMapping
  public String getGroupList(Model model){ //add String filter by first letters
    List<Group> groupList = groupService.getAllGroups();
    model.addAttribute("groups", groupList);

    return "/group/groupList";
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping("/new")
  public String getGroupRegisterForm(Model model){
    return "/group/groupAdd";
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @PostMapping("/new")
  public String addGroup(Model model, Group group){
    if(groupService.getByGroupFullId(group.getGroupFullId()) != null){
      model.addAttribute("message", "Group with the same id is already present!");
      return "/group/groupAdd";
    }
    groupService.saveGroup(group);
    return "redirect:/groups";
  }




}
