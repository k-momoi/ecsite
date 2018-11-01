## 主な機能
・ユーザー登録機能

・ログイン機能

・商品購入・削除機能

・購入履歴確認機能


## Schema
### Table (login_user_transaction)
>id int not null primary key auto_increment,

>login_id varchar(16) unique,

>login_pass varchar(16),

>user_name varchar(50),

>insert_date datetime,

>updated_date datetime


### Table (item_info_transaction)
>id int not null primary key auto_increment,

>item_name varchar(30),

>item_price int,

>item_stock int,

>insert_date datetime,

>update_date datetime


### Table (user_buy_item_transaction)
>id int not null primary key auto_increment,

>item_transaction_id int,

>total_price int,

>total_count int,

>user_master_id varchar(16),

>pay varchar(30),

>insert_date datetime,

>update_date datetime
