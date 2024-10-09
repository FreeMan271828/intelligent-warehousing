package config;


// 使用注解的方式实现描Swagger的配置

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
@OpenAPIDefinition(
        // ## API的基本信息，包括标题、版本号、描述、联系人等
        info = @Info(
                title = "Intelligemt Warehousing",       // Api接口文档标题（必填）
                description = "智慧仓储API文档",      // Api接口文档描述
                version = "1.0.0",                                   // Api接口版本
                termsOfService = "https://example.com/",             // Api接口的服务条款地址
                license = @License(                                                // 设置联系人信息
                        name = "Apache 2.0",                                       // 授权名称
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"   // 授权信息
                )
        ),
        //security = @SecurityRequirement(name = "JWT-test"),
        // ## 表示服务器地址或者URL模板列表，多个服务地址随时切换（只不过是有多台IP有当前的服务API）
        servers = {
                @Server(url = "http://127.0.0.1:8080/", description = "本机服务")
        }
        //externalDocs = @ExternalDocumentation(description = "更多内容请查看该链接", url = "xxx")
)
@SecurityScheme(
        name = "JWT",                        // 认证方案名称
        type = SecuritySchemeType.HTTP,      // 认证类型，当前为http认证
        description = "这是一个认证的描述详细",  // 描述信息
        in = SecuritySchemeIn.HEADER,        // 代表在http请求头部
        scheme = "bearer",                   // 认证方案，如：Authorization: bearer token信息
        bearerFormat = "JWT")                // 表示使用 JWT 格式作为 Bearer Token 的格式
@SecurityScheme(
        name = "X-API-KEY",
        type = SecuritySchemeType.APIKEY,
        description = "这是一个认证的描述详细",
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer")
public class SwaggerConfig {

}
