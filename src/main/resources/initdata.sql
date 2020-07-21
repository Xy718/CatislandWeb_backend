-- 帖子数据
INSERT INTO catisland_ivory.topic (content,create_time,imgs,status_flag,title,`uid`,update_time) VALUES 
('哼  哼  啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊，这是文案哦❥(^_-)','2020-06-20 22:35:38.0','["https://towerimg.ivory-tower.co/battle/b1.png", "https://towerimg.ivory-tower.co/battle/b2.png", "https://towerimg.ivory-tower.co/battle/b3.png", "https://towerimg.ivory-tower.co/battle/b4.png", "https://towerimg.ivory-tower.co/battle/b5.png", "https://towerimg.ivory-tower.co/battle/b6.png"]','0',NULL,0,'2020-06-20 22:35:42.0')
,('第二条的内容','2020-06-20 22:35:38.0','["https://towerimg.ivory-tower.co/2020-02-29_19.39.07.png", "https://towerimg.ivory-tower.co/2020-02-29_19.39.07.png", "https://towerimg.ivory-tower.co/2020-02-29_19.39.07.png"]','0',NULL,0,'2020-06-20 22:35:42.0')
,('第三条的内容','2020-06-20 22:35:38.0','["https://towerimg.ivory-tower.co/2020-02-29_19.40.29.png"]','0',NULL,0,'2020-06-20 22:35:42.0')
,('第四条的内容','2020-06-20 22:35:38.0','["https://towerimg.ivory-tower.co/2020-02-29_19.46.56.png"]','0',NULL,0,'2020-06-20 22:35:42.0')
;

-- 用户数据
INSERT INTO catisland_ivory.user 
(`uid`,avatar,email,nick_name,`password`,`password_salt`,phone,user_game_id,user_game_uuid,`user_name`,userintro) 
VALUES 
(0,'/assets/img/xy718_logo.jpg','869839000@qq.com','Xy718','{bcrypt}$2a$10$t8vTbC4BN0BI1ir6LagqNOIdK29k92ROKv2dP6YbwScxvGbdU54dO','0rnkhrbm','','','','Xy718','心·技·体')
;
