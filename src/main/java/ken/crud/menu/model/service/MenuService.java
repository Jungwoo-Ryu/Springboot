package ken.crud.menu.model.service;

import ken.crud.menu.model.dao.MenuMapper;
import ken.crud.menu.model.dto.CategoryAndMenuDTO;
import ken.crud.menu.model.dto.CategoryDTO;
import ken.crud.menu.model.dto.MenuAndCategoryDTO;
import ken.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenus() {

        return menuMapper.findAllMenus();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    /* 필기.
    *   @Transactional 은 스프링 프레임워크에서 제공하는 트랜젝션 관리를 지원한다
    *   트랜젝션은 데이터베이스의 상태를 변화시키는 작업을 하나의 단위로 묶는 작업을 의미한다.
    *   */
    @Transactional
    public void registNewMenu(MenuDTO newMenu) {
        menuMapper.registNewMenu(newMenu);
    }

    public List<MenuAndCategoryDTO> findAllMenuAndCategory() {

        return menuMapper.findAllMenuAndCategoryList();
    }

    public List<CategoryAndMenuDTO> findAllCategoryAndMenu() {
        return menuMapper.findAllCategoryAndMenuList();
    }
}
