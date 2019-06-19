Data Access Object(DAO) pattern Example & JDBC
=================

支援版本

• JAVA: 8+

• Maven: 3.6.1

• mysql-connector: 8.0.13


程式開啟前提醒:
--

### 請於您的MySQL 新增一個 Table ###
    CREATE TABLE `test`.`new_table` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `name` VARCHAR(45) NULL,
        `gender` VARCHAR(45) NULL,
        PRIMARY KEY (`id`)
        );
    
### 請至 [這裡](https://jar-download.com/artifacts/mysql/mysql-connector-java/8.0.13/source-code) 下載 mysql-connector-java-8.0.13.jar 放至您的 Classath

<br>

### 在Day5專案 目錄中開啟 cmd 並輸入以下指令建立專案 ###
    mvn package
 
### BUILD SUCCESS 之後,依序下列指令開啟專案 ###
    cd target
    java -cp Day5-0.0.1-SNAPSHOT.jar idv.Day5.EmpDaoPattemDemo C:\source-file.txt

### 您可以對 `source-file.txt` 內容進行修改 (以下為範例) ###

    #Information of DataBase Connection
    Connection.String=${jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai&useSSL=true}
    DB.User=${root}
    DB.Password=${root}

    #DataBase Operateion
    DB.Action=C
    DB.C.Data=JACK,male
    DB.R.ID=1
    DB.U.Data=4,SALA,female
    DB.D.ID=3
    
請注意 `Connection.String=${jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai&useSSL=true}` 輸入格式

`DB.Action` 為您想進行的行為 C/R/U/D  請擇一

C : 輸入資料並新增一筆資料

R : 輸入ID並查詢一筆資料

U : 輸入資料及ID並修改該筆ID資料

D : 輸入ID刪除一筆資料
