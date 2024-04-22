package ken.crud.menu.model.dto;

import java.util.List;

public class CategoryAndMenuDTO {
    private int code;
    private String name;
    private int refCategoryCode;
    private List<MenuDTO> menuDTO;

    public CategoryAndMenuDTO() {
    }

    public CategoryAndMenuDTO(int code, String name, int refCategoryCode, List<MenuDTO> menuDTO) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
        this.menuDTO = menuDTO;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<MenuDTO> getMenuDTO() {
        return menuDTO;
    }

    public void setMenuDTO(List<MenuDTO> menuDTO) {
        this.menuDTO = menuDTO;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuDTO=" + menuDTO +
                '}';
    }
}
