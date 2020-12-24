
CREATE TABLE person (
  person_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  person_loginid VARCHAR(20) NOT NULL,
  person_password VARCHAR(20) NOT NULL,
  person_name VARCHAR(20) NOT NULL,
  person_tel VARCHAR(15) default '010-0000-0000',
  person_address VARCHAR(20) NOT NULL
);

INSERT INTO person(person_loginid, person_password, person_name, person_tel, person_address) VALUES 
('smc5236', '1234', '손민철', '010-3171-8733', '경상남도 창원시'),
('kwon123', '1234', '권승준', '010-4575-7835', '인천광역시 계양구'), ('lee123', '1234', '이의현', '010-2187-5351', '경기도 고양시'),
('tae123', '1234', '이태일', '010-2478-2674', '경기도 의정부시'), ('uk123', '1234', '류현욱', '010-7456-8912', '경기도 평택시'),
('woo123', '1234', '우혜빈', '010-2077-3602', '경기도 수원시'), ('kang123', '1234', '강승훈', '010-4217-8421', '경상남도 창원시'),
('choi123', '1234', '최우림', '010-5436-9845', '광주광역시 남구'), ('jun123', '1234', '이준수', '010-5247-8514', '경상북도 문경시');



CREATE TABLE movie (
 movie_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 movie_name VARCHAR(20) NOT NULL,
 movie_time VARCHAR(20),
 movie_studio VARCHAR(20),
 movie_percent VARCHAR(20),
 movie_opening VARCHAR(20)
);


INSERT INTO movie (movie_name,movie_time,movie_studio,movie_percent,movie_opening)
VALUES ('극한직업 (1)','11:40','3관','30.5%','2019-11-02'),('극한직업 (2)','14:25','1관','30.5%','2019-11-02'),
('어벤져스:엔드게임 (1)','12:10','5관','21.5%','2019-11-13'),('어벤져스:엔드게임 (2)','18:55','4관','21.5%','2019-11-13'),
('베테랑','15:30','2관','15.4%','2019-11-15'),('겨울왕국 (1)','15:40','3관','12.6%','2019-11-23'),('겨울왕국 (2)','17:15','1관','12.6%','2019-11-23'),
('아바타','16:45','5관','20%','2019-11-17');


CREATE TABLE payments(
 p_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 payment VARCHAR(20)
 );
 
 
INSERT INTO payments (payment)
VALUES ('신용카드'),('무통장입금'),('계좌이체'),('현장결제'),('휴대폰결제'),('상품권결제');


CREATE TABLE seat_number(
 s_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 seat VARCHAR(20) NOT NULL
);
INSERT INTO seat_number (seat)
VALUES ('A열 1번'),('A열 2번'),('A열 3번'),('A열 4번'),('A열 5번'),('A열 6번'),('A열 7번'),('A열 8번'),
('B열 1번'),('B열 2번'),('B열 3번'),('B열 4번'),('B열 5번'),('B열 6번'),('B열 7번'),('B열 8번'),
('C열 1번'),('C열 2번'),('C열 3번'),('C열 4번'),('C열 5번'),('C열 6번'),('C열 7번'),('C열 8번'),
('D열 1번'),('D열 2번'),('D열 3번'),('D열 4번'),('D열 5번'),('D열 6번'),('D열 7번'),('D열 8번'),
('E열 1번'),('E열 2번'),('E열 3번'),('E열 4번'),('E열 5번'),('E열 6번'),('E열 7번'),('E열 8번'),
('F열 1번'),('F열 2번'),('F열 3번'),('F열 4번'),('F열 5번'),('F열 6번'),('F열 7번'),('F열 8번');


CREATE TABLE already_reserv(
  person_id INT NOT NULL,
  FOREIGN KEY (person_id)
  REFERENCES person (person_id),
  s_id INT NOT NULL,
  FOREIGN KEY (s_id)
  REFERENCES seat_number (s_id),
  movie_id INT NOT NULL,
  FOREIGN KEY(movie_id)
  REFERENCES movie (movie_id)
);

CREATE TABLE admin(
  admin_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  admin_loginid VARCHAR(20),
  admin_loginpw VARCHAR(20),
  admin_name VARCHAR(20),
  admin_position VARCHAR(20),
  admin_age VARCHAR(20),
  boss_id INT
);

INSERT INTO admin (admin_loginid, admin_loginpw, admin_name, admin_position, admin_age,boss_id)
VALUES ('minchul', '1234', '손민철', '프로그램 유지보수 담당','23',1), 
('uihyeon', '1234', '이의현', '영화 포스터 담당','23',1),
('seungjun', '1234', '권승준', '영화 정보 담당','23',1),
('taeil', '1234', '이태일', '결제 담당','24',1);

CREATE TABLE cgv(
  cgv_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cgv_name VARCHAR(20) NOT NULL,
  cgv_address VARCHAR (30) NOT NULL
);

INSERT INTO cgv (cgv_name, cgv_address)
VALUES ('CGV마산', '경상남도 창원시 마산회원구 3·15대로 736'), ('CGV창원', '경상남도 창원시 의창구 창원대로397번길 6'),
('CGV창원더시티', '경상남도 창원시 원이대로 320'), ('CGV천안', '충청남도 천안시 동남구 명동길 47'),
('CGV천안펜타포트', '충청남도 천안시 서북구 공원로 196'), ('CGV천안터미널', '충청남도 천안시 동남구 만남로 43'),
('CGV강남', '서울특별시 강남구 강남대로 438'), ('CGV압구정', '서울특별시 강남구 압구정로30길 45'),
('CGV목동', '서울특별시 양천구 목동동로 257'), ('CGV용산아이파크몰', '서울특별시 용산구 한강대로23길 55'),
('CGV명동', '서울특별시 중구 명동길 14'), ('CGV동수원', '경기도 수원시 팔달구 권광로 181'),
('CGV북수원', '경기도 수원시 장안구 경수대로 950'), ('CGV수원', '경기도 수원시 팔달구 덕영대로 924'),
('CGV계양', '인천광역시 계양구 장제로 738'), ('CGV주안역', '인천광역시 미추홀구 염창로 58'),
('CGV인천', '인천광역시 남동구 예술로 198'), ('CGV부평', '인천광역시 부평구 마장로 489'),
('CGV일산', '경기도 고양시 일산동구 정발산로 24'), ('CGV화정', '경기도 고양시 덕양구 화중로 104번길 28'),
('CGV의정부', '경기도 의정부시 평화로 525'), ('CGV의정부태흥', '경기도 의정부시 시민로 80'),
('CGV 평택', '경기도 평택시 평택로 51'), ('CGV평택소사', '경기도 평택시 평남로 862');


CREATE TABLE reservation_info (
  person_id INT NOT NULL,
  FOREIGN KEY (person_id)
  REFERENCES person (person_id),
  movie_id INT NOT NULL,
  FOREIGN KEY (movie_id)
  REFERENCES movie (movie_id),
  p_id INT NOT NULL,
  FOREIGN KEY (p_id)
  REFERENCES payments (p_id),
  amount VARCHAR(20), 
  price VARCHAR(20)
);




























