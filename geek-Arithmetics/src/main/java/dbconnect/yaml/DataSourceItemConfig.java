package dbconnect.yaml;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName DataSourceItemConfig
 * @Author Leo
 * @Description //TODO
 * @Date: 2018/12/22 18:27
 **/
@Getter
@Setter
public class DataSourceItemConfig {

    private String username;

    private String password;

    private String driverClassName;

    private String url;

}