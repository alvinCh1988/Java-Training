# Spring MVC `JPA` `thymeleaf` `Bootstrap` `AOP` `logback`

支援版本

• JAVA: 8+

• Maven: 3

• Spring: 2.1.6

• Bootstrap: 4

    
src\main\resources\application.yml
更改你的 DB資料

    spring:
     datasource:
        url: jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai&useSSL=true
        username: root
        password: root
       
log等級 & log文件輸出路徑
      logging:
        level:
        root: error
        com.yao.demo: warn
        file: spring-boot-logger/island-training


### 專案下載後 目錄中開啟 cmd 並輸入以下指令建立WAR檔 ###
    mvn compile war:war

BUILD SUCCESS 之後
至target 資料夾中 建立好的 springD6-0.0.1-SNAPSHOT.war
部屬至您的 server

    C:\apache-tomcat-9.0.21\webapps
    
    
開啟server後
於瀏覽器輸入

http://localhost:8080/account/

於第一次開啟專案後
可以在註冊時
Account Name 名稱 打上 admin
即可新增一個 管理員 等級的帳號


