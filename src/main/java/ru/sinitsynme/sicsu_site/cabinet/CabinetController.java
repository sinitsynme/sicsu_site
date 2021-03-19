package ru.sinitsynme.sicsu_site.cabinet;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.UserData;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;
import ru.sinitsynme.sicsu_site.user.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

  private final UserDetailsServiceImpl userDetailsService;

  @Autowired
  public CabinetController(
      UserDetailsServiceImpl userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @GetMapping
  public String getCabinetPage(Model model) {
    Optional<UserData> optionalUserData = userDetailsService.getCurrentUserData();
    if (optionalUserData.isPresent()) {
      UserData userData = optionalUserData.get();
      model.addAttribute("userData", userData);
      if(userData instanceof StudentData){
        return "cabinet/student";
      }
      else if(userData instanceof TeacherData){
        return "cabinet/teacher";
      }
    }
    model.addAttribute("error", "Missing data");
    return "errorPage";
  }

}
