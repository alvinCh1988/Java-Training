Data Access Object(DAO) pattern Example & JDBC
=================

支援版本

• JAVA: 8+

• Maven: 3.6.1

• mysql-connector: 8.0.13


程式開啟前準備:
--

### MySQL 新增 Table (欄位為 id(PK), name, gender) ###
    CREATE TABLE `testDB`.`day5` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `name` VARCHAR(45) NULL,
        `gender` VARCHAR(45) NULL,
        PRIMARY KEY (`id`)
     );

<br>

### 專案 目錄中開啟 cmd 並輸入以下指令建立專案 ###
    mvn package
    
### 請至 [這裡](https://jar-download.com/artifacts/mysql/mysql-connector-java/8.0.13/source-code) 下載 mysql-connector-java-8.0.13.jar 放至 Day5/target中 
 
### BUILD SUCCESS AFTER ###
    cd target
    java -cp .\* idv.Day5.EmpDaoPattemDemo C:\source-file.txt

### 可對 `source-file.txt` 內容進行修改 ###

    #Information of DataBase Connection
    Connection.String=${jdbc:mysql://localhost:3306/testDB?serverTimezone=Asia/Shanghai&useSSL=true}
    DB.User=${root}
    DB.Password=${root}

    #DataBase Operateion
    DB.Action=C
    DB.C.Data=JACK,male
    DB.R.ID=1
    DB.U.Data=4,SALA,female
    DB.D.ID=3
    

`DB.Action` 為您想進行的行為 C/R/U/D  請擇一

C : 輸入資料並新增一筆資料

R : 輸入ID並查詢一筆資料

U : 輸入資料及ID並修改該筆ID資料

D : 輸入ID刪除一筆資料
