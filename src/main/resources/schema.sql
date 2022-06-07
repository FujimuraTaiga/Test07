DROP TABLE IF EXISTS cafeteria_menu;

CREATE TABLE IF NOT EXISTS cafeteria_menu(
    id VARCHAR(8),
    name VARCHAR(32),
    explain VARCHAR(4096),
    image BLOB(65536),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS cafeteria_post(
    postId VARCHAR(8),
    menuId VARCHAR(8),
    evaluation DOUBLE,
    comment VARCHAR(4096),
    PRIMARY KEY(postId)
);

DROP TABLE IF EXISTS class;

CREATE TABLE IF NOT EXISTS class(
    id VARCHAR(8),
    name VARCHAR(32),
    explain VARCHAR(4096),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS class_post(
    postId VARCHAR(8),
    classId VARCHAR(8),
    evaluation DOUBLE,
    comment VARCHAR(4096),
    PRIMARY KEY(postId)
);

CREATE TABLE IF NOT EXISTS thread(
    id VARCHAR(8),
    name VARCHAR(128),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS thread_post(
    postId VARCHAR(8),
    threadId VARCHAR(8),
    comment VARCHAR(4096),
    PRIMARY KEY(postId)
);