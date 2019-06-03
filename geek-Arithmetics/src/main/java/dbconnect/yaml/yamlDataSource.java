package dbconnect.yaml;

import com.alibaba.fastjson.JSON;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName yamlDataSource
 * @Author Leo
 * @Description snakeyaml解析
 * @Date: 2018/12/22 14:05
 **/
public class yamlDataSource {

    /**
     * 这个yaml文件要放在resources目录下
     */
    private static final String YAML_FILE_PATH = "yaml/datasource.yaml";

    public static void main(String[] args) throws Exception {
        System.out.println(JSON.toJSONString(
                unmarshal(yamlDataSource.class.getClassLoader().getResourceAsStream(YAML_FILE_PATH))));
    }

    private static DataSourceConfig unmarshal(final InputStream is) throws IOException {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8")
        ) {
            return new Yaml(new Constructor(DataSourceConfig.class)).loadAs(inputStreamReader, DataSourceConfig.class);
        }
    }
}
