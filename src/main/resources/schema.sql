DROP TABLE IF EXISTS cafeteria_menu;

CREATE TABLE IF NOT EXISTS cafeteria_menu(
    id VARCHAR(8),
    name VARCHAR(32),
    explain VARCHAR(4096),
    image VARCHAR(64),
    PRIMARY KEY(id)
);

INSERT INTO cafeteria_menu VALUES('00000001','カレー','286円','curry');
INSERT INTO cafeteria_menu VALUES('00000002','竜田丼','506円','tatsuta-don');
INSERT INTO cafeteria_menu VALUES('00000003','ハンバーグ','308円','hamburg');
INSERT INTO cafeteria_menu VALUES('00000004','ご飯（小）','66円','small-rice');
INSERT INTO cafeteria_menu VALUES('00000005','ご飯（中）','99円','medium-rice');
INSERT INTO cafeteria_menu VALUES('00000006','ご飯（大）','132円','large-rice');
INSERT INTO cafeteria_menu VALUES('00000007','ラーメン','396円','ramen');
INSERT INTO cafeteria_menu VALUES('00000008','うどん','253円','udon');
INSERT INTO cafeteria_menu VALUES('00000009','アジフライ','264円','flied-fish');
INSERT INTO cafeteria_menu VALUES('00000010','フライドチキン','176円','flied-chicken');

CREATE TABLE IF NOT EXISTS cafeteria_post(
    postId VARCHAR(8),
    menuId VARCHAR(8),
    evaluation INT,
    comment VARCHAR(4096),
    PRIMARY KEY(postId)
);

MERGE INTO cafeteria_post VALUES('aaaaaaaa','00000001',4,'うまい');
MERGE INTO cafeteria_post VALUES('bbbbbbbb','00000002',4,'うまい');
MERGE INTO cafeteria_post VALUES('cccccccc','00000003',4,'うまい');
MERGE INTO cafeteria_post VALUES('dddddddd','00000004',4,'うまい');
MERGE INTO cafeteria_post VALUES('eeeeeeee','00000005',4,'うまい');
MERGE INTO cafeteria_post VALUES('ffffffff','00000006',4,'うまい');
MERGE INTO cafeteria_post VALUES('gggggggg','00000007',4,'うまい');
MERGE INTO cafeteria_post VALUES('hhhhhhhh','00000008',4,'うまい');
MERGE INTO cafeteria_post VALUES('iiiiiiii','00000009',4,'うまい');
MERGE INTO cafeteria_post VALUES('jjjjjjjj','00000010',4,'うまい');


DROP TABLE IF EXISTS class;

CREATE TABLE IF NOT EXISTS class(
    id VARCHAR(8),
    department VARCHAR(32),
    major VARCHAR(32),
    name VARCHAR(32),
    PRIMARY KEY(id)
);

INSERT INTO class VALUES('00000001','工学部','情報工学科','高度情報演習IB');
INSERT INTO class VALUES('00000002','工学部','情報工学科','データベース');
INSERT INTO class VALUES('00000003','工学部','情報工学科','人工知能');
INSERT INTO class VALUES('00000004','工学部','情報工学科','数理計画法');
INSERT INTO class VALUES('00000005','工学部','機械機能工学科','熱力学１');
INSERT INTO class VALUES('00000006','工学部','機械工学科','振動工学');
INSERT INTO class VALUES('00000007','工学部','応用化学科','物理学実験');
INSERT INTO class VALUES('00000008','システム理工学部','数理科','創る');

CREATE TABLE IF NOT EXISTS class_post(
    postId VARCHAR(8),
    classId VARCHAR(8),
    evaluation INT,
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