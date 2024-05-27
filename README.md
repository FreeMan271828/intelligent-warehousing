# intelligent-warehousing

1. 命令规范
   1. 命名文件夹使用小写开头，命名文件使用大写开头。
   2. 命名变量使用驼峰法或下划线，不允许使用无意义标志，不允许使用拼音（太low了）。
   3. 不会lambda表达式或者迭代器的同学可以使用普通循环，普通循环变量可以使用i,j等无意义字符。
   4. 在git commit -m "commit info"中的commit info中最好写明增加、修改了什么。
2. 项目语言、框架版本
   1. Group-id: org.iwp
   2. Artifical-id: intelligentwarehousing
   3. Spring boot version: 3.2.4
   4. Java version: 21
   5. Html version: 5
   6. Mybatis: 2.12
3. 项目组成
   1. 前端约束
      1. html代码存放在/resources/templates下
      2. css代码存放在/resources/static/css下，使用时`<link rel="stylesheet" href="/css/yourfile.css">`即可
      3. javascript代码存放在/resources/static/javascript下，使用时`<script src="/javascript/yourfile.js?v=1.0"></script>`，要求javascript写完初版后，每次修改都要把`v=1.0`加上0.1
      4. 图片存放在/resources/static/picture下
   2. 后端约束
      1. 数据层
         1. dataobject 用于存储数据实体
         2. dao 用户数据实体与数据库的连接
         3. model 表示在框架中的通用模型
      2. 服务层 service 要求创建对应接口（易于使用控制反转），然后再/service/impl下创建对应的实现类，实现类应命名为接口名+Impl
      3. 接口层 controller 要求创建对应api服务 
      4. 表示层 resources/static resources/templates下
4. 人员组成
   黄施远
   韩铭佳
   李欣韫
   李青秋
   杨靖宇
   戴宇宸
