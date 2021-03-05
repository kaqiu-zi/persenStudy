# 网盘设计稿
1、创建工程  
2、引入需要的依赖  
3、创建通用模板  
4、设计数据库表  
5、根据数据库表生成mapper  
6、待定  

## 数据库表的设计
用户表 user  
id int 主键id  
username var 用户名
email var 邮箱
password var 密码  
nickname var 昵称  
avatarFileId int 头像文件id  
avatarUrl var 头像文件url  
right int 权限  
capacity int 网盘容量  
footprint int 占用空间
status int 状态  
create time 创建时间  
update time 修改时间  

文件表 file  
id int 主键id  
user_id int 所属用户id  
file_name var 文件名  
target_url var 文件url  
file_type int 文件类型  
folder_id var 所在的文件夹id  
size int 文件大小  
hash var md5加密码  
status int 状态  
create time 创建时间  
update time 修改时间  

文件夹表 folder  
id int 主键id  
user_id int 所属用户id  
name var 文件夹名  
folder_id var 所在的文件夹id  
status int 状态  
create time 创建时间  
update time 修改时间  


