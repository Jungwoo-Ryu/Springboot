package ken.crud.menu.model.dao;

import ken.crud.menu.model.dto.CategoryAndMenuDTO;
import ken.crud.menu.model.dto.CategoryDTO;
import ken.crud.menu.model.dto.MenuAndCategoryDTO;
import ken.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuAndCategoryDTO> findAllMenuAndCategoryList();

    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO newMenu);

    List<CategoryAndMenuDTO> findAllCategoryAndMenuList();
}
