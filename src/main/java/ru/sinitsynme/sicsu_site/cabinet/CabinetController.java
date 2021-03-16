package ru.sinitsynme.sicsu_site.cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    if (userDetailsService.getCurrentUserData().isPresent()) {
      model.addAttribute("userData", userDetailsService.getCurrentUserData().get());
      return "cabinet";
    }
    model.addAttribute("error", "Missing data");
    return "cabinet";
  }


}
