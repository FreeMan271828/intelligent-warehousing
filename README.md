# intelligent-warehousing

1. 命令规范
   1. 命名文件夹使用小写开头，命名文件使用大写开头。
   2. 命名变量使用驼峰法或下划线，不允许使用无意义标志，不允许使用拼音（太low了）。
   3. 不会lambda表达式或者迭代器的同学可以使用普通循环，普通循环变量可以使用i,j等无意义字符。
   4. 在git commit -m "commit info"中的commit info中最好写明增加、修改了什么。
2. 项目
   1. Group-id: org.iwp
   2. Artifical-id: intelligentwarehousing
   3. Spring boot version: 3.2.4
   4. Java version: 21
   5. Html version: 5
3. 前端约束
   1. html代码存放在/resources/templates下
   2. css代码存放在/resources/static/css下，使用时`<link rel="stylesheet" href="/css/yourfile.css">`即可
   3. javascript代码存放在/resources/static/javascript下，使用时`<script src="/javascript/yourfile.js?v=1.0"></script>`，要求javascript写完初版后，每次修改都要把`v=1.0`加上0.1
   4. 图片存放在/resources/static/picture下
4. 后端约束
   1. controller存放在/control下
   2. model存放在/model下，在model中一个文件只定义一个类，要求在model里的方法只有getter, setter, 构造, 析构，不允许出现复杂的方法
   3. service存放在/service下，首先要求创建对应接口（易于使用控制反转），然后再/service/impl下创建对应的实现类，实现类应命名为接口名+Impl
   4. 在service下实现复杂方法，比如数据库接入，算法等等
   5. 初始化数据使用`static{}`或者

        ``` java
        @PostControl
        private static final void init(){}
        ```

   6. 在项目中打印重要信息不允许使用`System.out.println()`（因为SpringBoot有多线程，你不会知道到底打印哪去了），打印信息使用日志，日志类使用`private final Logger LOG = LoggerFactory.getLogger(yourFile.class)`，然后`LOG.info() LOG.warn() LOG.error()`即可打印一般信息，警告信息，错误信息
5. 备注
   所有文件下的temp文件不要动，是占位符。
6. 人员组成
   黄施远
   韩铭佳