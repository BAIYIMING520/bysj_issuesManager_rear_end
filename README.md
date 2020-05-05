# bysj_issuesManager_rear_end
JavaSpringboot 后端springweb项目
tips:
本次毕业设计前后端分离
前端请参考 ../bysj_issuesManager_front_end

后端部分使用使用了spring web
遵循了RESTful设计架构
使用了mvc设计模式
DAO层使用了Jpa完成对数据库的数据管理
数据库：
Entity 
+------------------+
| Tables_in_issues 
+------------------+
| data            
| description      
| message         
| tables          
| tag             
| toDoList        
| user            
| usermessage      
+------------------+

对于前后端分离的设计：
使用了@config标注的跨域访问
对于身份验证则使用了Jwt
