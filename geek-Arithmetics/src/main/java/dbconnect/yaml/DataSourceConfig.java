package dbconnect.yaml;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @ClassName DataSourceConfig
 * @Author Leo
 * @Description //TODO
 * @Date: 2018/12/22 18:26
 **/
@Getter
@Setter
public class DataSourceConfig {

    private Map<String, DataSourceItemConfig> rdb;

    private Map<String, DataSourceItemConfig> nosql;

    private Map<String, DataSourceItemConfig> newsql;

}
