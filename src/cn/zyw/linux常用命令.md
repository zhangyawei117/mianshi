##### 1、Linux常用命令
----
命令|作用  
:--: | :--:  
cd ..|到上一级目录  
ll|列出当前目录下的所有文档  
ls|列出目录下的文件  
ls -a|列出文件下所有的文件，包括以“.“开头的隐藏文件（linux下文件隐藏文件是以.开头的，如果存在..代表存在着父目录）  
ls -l|列出文件的详细信息，如创建者，创建时间，文件的读写权限列表等等  
ls -F|在每一个文件的末尾加上一个字符说明该文件的类型。"@"表示符号链接、"|"表示FIFOS、"/"表示目录、"="表示套接字。  
ls -s|在每个文件的后面打印出文件的大小, size(大小)  
ls -t|按时间进行文件的排序 Time(时间)  
ls -A|列出除了"."和".."以外的文件。  
ls -R|将目录下所有的子目录的文件都列出来，相当于我们编程中的“递归”实现  
ls -L|列出文件的链接名。Link（链接）  
ls -S|以文件的大小进行排序  
pwd   |查看当前工作目录路径  
pwd -P|查看软链接的实际路径  
mkdir t|当前工作目录下创建名为t的文件夹 
mkdir -p /tmp/test/t1/t|在tmp目录下创建路径为test/t1/t的目录，若不存在，则创建  


ps -ef|grep tomcat|查看tomcat进程  
tar –xvf file.tar|解压 tar包  
tar -xzvf file.tar.gz|解压tar.gz  
tar -xjvf file.tar.bz2|解压 tar.bz2  
tar –xZvf file.tar.Z|解压tar.Z  
unrar e file.rar|解压rar  
unzip 压缩包名字|解压缩zip的压缩包（例如：unzip apache-tomcat-7.0.67.zip）
kill -pid（pid是tomcat的进程号） 5144|杀死tomcat进程（例如：kill -9 5144）  
cat 相关文件名|查看此文件详细,例如：cat test.txt或more test.txt，区别为more一页一页显示，还可以用cat test.txt|more  
tail|查看文件后面的内容，默认为查看文件后10行内容;例如：tail –f portal.log ，显示portal.log的最后10行，并实时显示最新内容；tail -100f portal.log  显示portal.log的最后100行内容；tail –n 20 portal.log  指定从文件末尾开始读取的行数；tail –c 200 portal.log |pg   从第200字节开始，每次显示一页文件； sed -n '5,10p'    查看文件中间一段  
head|查看文件前面的内容，默认是查看文件前10行内容;例如：head -20 install.log，查看install.log这个文件前面20行的内容  

#### 2、linux下修改tomcat端口号？
tomcat/conf/server.xml，在conf目录下，server.xml里面，找到8080，改为80，在vim模式下，wq保存即可；  
***关于开放tomcat端口和关闭linux防火墙的设置***：  
-A INPUT -m state --state NEW -m tcp -p tcp --dport 8080 -j ACCEPT （开放80端口）；  
chkconfig iptables off （重启后关闭防火墙）；  
service iptables restart 重启防火墙。  

#### 3、tomcat的优化有没有做过？
***tomcat内存优化***  
linux修改TOMCAT_HOME/bin/catalina.sh，在前面加入:  
```JAVA_OPTS="-XX:PermSize=64M -XX:MaxPermSize=128m -Xms512m -Xmx1024m -Duser.timezone=Asia/Shanghai"
```  
windows修改TOMCAT_HOME/bin/catalina.bat，在前面加入:  
```set JAVA_OPTS=-XX:PermSize=64M -XX:MaxPermSize=128m -Xms512m -Xmx1024m
```  
>最大堆内存是1024m，对于现在的硬件还是偏低，实施时，还是按照机器具体硬件配置优化。

***tomcat线程优化***  
在server.xml里面：  
```<Connector port="80" protocol="HTTP/1.1" maxThreads="600" minSpareThreads="100" maxSpareThreads="500" acceptCount="700"
connectionTimeout="20000" redirectPort="8443" />   
maxThreads="600"       ///最大线程数
minSpareThreads="100"///初始化时创建的线程数
maxSpareThreads="500"///一旦创建的线程超过这个值，Tomcat就会关闭不再需要的socket线程。
acceptCount="700"//指定当所有可以使用的处理请求的线程数都被使用时，可以放到处理队列中的请求数，超过这个数的请求将不予处理
```  
这里是http connector的优化，如果使用apache和tomcat做集群的负载均衡，并且使用ajp协议做apache和tomcat的协议转发，
那么还需要优化ajp connector;  
```<Connector port="8009" protocol="AJP/1.3" maxThreads="600" minSpareThreads="100" maxSpareThreads="500" acceptCount="700"
   connectionTimeout="20000" redirectPort="8443" />
```  
***设置session过期时间***  
conf\web.xml中通过参数指定：  
```<session-config>   
      <session-timeout>180</session-timeout>     
   </session-config> 
   单位为分钟。
```  
***禁用DNS查询***  
server.xml文件中的Connector元素，修改属性enableLookups参数值: enableLookups="false；  
如果为true，则可以通过调用request.getRemoteHost()进行DNS查询来得到远程客户端的实际主机名，
若为false则不进行DNS查询，而是返回其ip地址；  
***IO优化***  
server.xml中：
<Connector port="80" protocol="org.apache.coyote.http11.Http11NioProtocol" 
    connectionTimeout="20000" 
    URIEncoding="UTF-8" 
    useBodyEncodingForURI="true" 
    enableLookups="false" 
    redirectPort="8443" />







                                
                                
                  

