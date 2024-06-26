package ken.crud.menu.controller;

import ken.crud.menu.model.dto.CategoryAndMenuDTO;
import ken.crud.menu.model.dto.CategoryDTO;
import ken.crud.menu.model.dto.MenuAndCategoryDTO;
import ken.crud.menu.model.dto.MenuDTO;
import ken.crud.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);
    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    MenuController(MenuService menuService, MessageSource messageSource){
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String findMenuList(Model model){
        List<MenuDTO> menulist = menuService.findAllMenus();
        model.addAttribute("menuList", menulist);

        return "menu/list";
    }

    @GetMapping("regist")
    public void registPage() {
    }

    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    public String registMenu(MenuDTO newMenu, RedirectAttributes rttr, Locale locale){
        menuService.registNewMenu(newMenu);
//        locale : 지역(나라) 에 대한 정보 다국어 처리와 관련 된 정보
        logger.info("Locale : {}", locale);
        rttr.addFlashAttribute("successMessage",
                messageSource.getMessage("registMenu", new Object[]{
                newMenu.getName(), newMenu.getPrice()
        }, locale));

        return "redirect:/menu/list";
    }

    @GetMapping("joinCategory/list")
    public String menuAndCategory(Model model){

        List<MenuAndCategoryDTO> menuAndCategoryList = menuService.findAllMenuAndCategory();

        model.addAttribute("menuAndCategoryList", menuAndCategoryList);


        return "menu/joinMenu";
    }

    @GetMapping("joinMenu/list")
    public String categoryAndMenu(Model model){
        List<CategoryAndMenuDTO> categoryAndMenuList = menuService.findAllCategoryAndMenu();

        model.addAttribute("categoryAndMenuList", categoryAndMenuList);

        return "menu/joinCategory";
    }
}
