package ken.crud.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "ken.crud", annotationClass = Mapper.class)
public class CrudLectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudLectureApplication.class, args);
    }

}
