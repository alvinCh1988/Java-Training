# Spring MVC  `JSP` `NO JPA`

支援版本

• JAVA: 8+

• Maven: 3

• Spring: 2.6.1

### 請先在你的MySQL 新增一個TABLE ###
    CREATE TABLE `test1`.`account` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `account` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NULL,
    `firstName` VARCHAR(45) NULL,
    `imgPath` VARCHAR(45) NULL,
    PRIMARY KEY (`id`));
    
於 src\main\resources\application.yml
更改你的 DB資料

    spring:
     datasource:
        url: jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai&useSSL=true
        driver-class-name: com.mysql.cj.jdbc.Driver
        data-username: root
        data-password: root


### 專案下載後 目錄中開啟 cmd 並輸入以下指令建立WAR檔 ###
    mvn compile war:war

BUILD SUCCESS 之後
至target 資料夾中 建立好的 springD4-0.0.1-SNAPSHOT.war
部屬至您的 server

    C:\apache-tomcat-9.0.21\webapps
    
    
    
    
開啟server後
於瀏覽器輸入

http://localhost:8080/login
