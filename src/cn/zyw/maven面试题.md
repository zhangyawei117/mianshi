#### maven的聚合和继承怎么理解？  

#### maven常用的插件有哪些？  

#### maven的构建过程？


### maven常用的命令  
命令|作用  
--| :--:
mvn compile|编译  
mvn test|测试  
mvn test-compile|编译测试代码  
mvn clean|清理tartet下的文件  
mvn package|打包  
mvn install|构建到本地仓库  
mvn deploy|上传到私服  
mvn site|产生site  
mvn idea:idea|生成idea项目  
mvn eclipse:eclipse|生成eclipse项目  
mvn eclipse:clean|清除eclipse的一些系统设置  
mvn -Dtest package|组合使用goal命令，如只打包不测试  
mvn test-compile|编译测试的内容  
mvn jar:jar|只打jar包  
mvn test -skipping compile -skipping test-compile( -skipping 的灵活运用，当然也可以用于其他组合命令)|只测试而不编译，也不测试编译  
dependency:sources  或者   -U idea:idea| idea下载不下来jar包 
mvn install -Dmaven.test.skip=true -Pdevelop|跳过测试打develop分支的包  
mvn package -DskipTests|打包的时候跳过测试  
mybatis-generator:generate|使用mybatis-generator插件生成实体类  
-s D:\Develop\apache-maven-3.5.2\conf\settings.xml install -f   pom.xml -X -P develop -e -U -Dmaven.test.skip=true|跳过测试，打包，并从私服下载最新的jar包  
mvn archetype:create -DgroupId=packageName -DartifactId=projectName|创建Maven的普通Java项目  
mvn archetype:create -DgroupId=packageName -DartifactId=webappName -DarchetypeArtifactId=maven-archetype-webapp|创建Maven的Web项目  
mvn archetype:generate -DgroupId=otowa.user.dao -DartifactId=user-dao -Dversion=0.01-SNAPSHOT|创建maven项目  
mvn dependency:list|查看当前项目已被解析的依赖  
mvn clean install-U|强制检查更新，由于快照版本的更新策略(一天更新几次、隔段时间更新一次)存在，如果想强制更新就会用到此命令  
mvn source:jar 或mvn source:jar-no-fork|源码打包  
mvn jetty:run|运行项目于jetty上  
mvn -e|显示详细错误 信息  
mvn validate|验证工程是否正确，所有需要的资源是否可用  
mvn integration-test|在集成测试可以运行的环境中处理和发布包  
mvn verify|运行任何检查，验证包是否有效且达到质量标准  
mvn generate-sources|产生应用需要的任何额外的源代码，如xdoclet  
mvn help:describe -Dplugin=help|使用 help 插件的describe目标来输出Maven Help插件的信息  
mvn help:describe -Dplugin=help -Dfull|使用Help插件输出完整的带有参数的目标列  
mvn help:describe -Dplugin=compiler -Dmojo=compile -Dfull|获取单个目标的信息,设置mojo参数和plugin参数。此命令列出了Compiler插件的compile 目标的所有信息  
mvn help:describe -Dplugin=exec -Dfull|列出所有 Maven Exec 插件可用的目标  
mvn dependency:tree|打印整个依赖树  
mvn dependency:resolve|打印出已解决依赖的列表  
-Dmaven.tomcat.port=9090|指定tomcat的端口  
-Dmaven.test.failure.ignore=true|忽略测试失败  
