-- 各種テーブル削除
DROP TABLE IF EXISTS goals;
DROP TABLE IF EXISTS tasks;

-- 目標テーブル
CREATE TABLE goals
(
id SERIAL PRIMARY KEY,
name TEXT
);
-- タスクテーブル
CREATE TABLE tasks
(
id SERIAL PRIMARY KEY,
goal_id INTEGER,
name TEXT,
num INTEGER
);