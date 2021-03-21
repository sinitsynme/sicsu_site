package ru.sinitsynme.sicsu_site.cabinet;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinitsynme.sicsu_site.user.data.UserData;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;
import ru.sinitsynme.sicsu_site.user.service.UserDetailsServiceImpl;
import ru.sinitsynme.sicsu_site.user.service.UserService;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

  private final UserService userService;

  @Autowired
  public CabinetController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String getCabinetPage(Model model) {
    Optional<UserData> optionalUserData = userService.getCurrentUserData();
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
