MergeSort & Bubble Sort by Spring
=================

支援版本

• JAVA: 8+

• Maven: 3

• Spring: 2.5.1


### 專案下載後 目錄中開啟 cmd 並輸入以下指令建立專案 ###
    mvn package
    

### BUILD SUCCESS 之後,依序下列指令開啟專案 ###
    cd target
    java -jar Spring-Day2-0.0.1-SNAPSHOT.jar file:C:/source-file.txt
    
(確保您的 source-file.txt 檔案路徑正確)

### 您可以對 `source-file.txt` 內容進行修改 (以下為範例) ###
    value-list=10,44,55,66,78,100,101,8897,10001 (請用 ',' 作為數字間隔)
    method=merge or bubble
