
CREATE TABLE person (
  person_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  person_loginid VARCHAR(20) NOT NULL,
  person_password VARCHAR(20) NOT NULL,
  person_name VARCHAR(20) NOT NULL,
  person_tel VARCHAR(15) default '010-0000-0000',
  person_address VARCHAR(20) NOT NULL
);

INSERT INTO person(person_loginid, person_password, person_name, person_tel, person_address) VALUES 
('smc5236', '1234', '�չ�ö', '010-3171-8733', '��󳲵� â����'),
('kwon123', '1234', '�ǽ���', '010-4575-7835', '��õ������ ��籸'), ('lee123', '1234', '������', '010-2187-5351', '��⵵ ����'),
('tae123', '1234', '������', '010-2478-2674', '��⵵ �����ν�'), ('uk123', '1234', '������', '010-7456-8912', '��⵵ ���ý�'),
('woo123', '1234', '������', '010-2077-3602', '��⵵ ������'), ('kang123', '1234', '������', '010-4217-8421', '��󳲵� â����'),
('choi123', '1234', '�ֿ츲', '010-5436-9845', '���ֱ����� ����'), ('jun123', '1234', '���ؼ�', '010-5247-8514', '���ϵ� �����');



CREATE TABLE movie (
 movie_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 movie_name VARCHAR(20) NOT NULL,
 movie_time VARCHAR(20),
 movie_studio VARCHAR(20),
 movie_percent VARCHAR(20),
 movie_opening VARCHAR(20)
);


INSERT INTO movie (movie_name,movie_time,movie_studio,movie_percent,movie_opening)
VALUES ('�������� (1)','11:40','3��','30.5%','2019-11-02'),('�������� (2)','14:25','1��','30.5%','2019-11-02'),
('�����:������� (1)','12:10','5��','21.5%','2019-11-13'),('�����:������� (2)','18:55','4��','21.5%','2019-11-13'),
('���׶�','15:30','2��','15.4%','2019-11-15'),('�ܿ�ձ� (1)','15:40','3��','12.6%','2019-11-23'),('�ܿ�ձ� (2)','17:15','1��','12.6%','2019-11-23'),
('�ƹ�Ÿ','16:45','5��','20%','2019-11-17');


CREATE TABLE payments(
 p_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 payment VARCHAR(20)
 );
 
 
INSERT INTO payments (payment)
VALUES ('�ſ�ī��'),('�������Ա�'),('������ü'),('�������'),('�޴�������'),('��ǰ�ǰ���');


CREATE TABLE seat_number(
 s_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 seat VARCHAR(20) NOT NULL
);
INSERT INTO seat_number (seat)
VALUES ('A�� 1��'),('A�� 2��'),('A�� 3��'),('A�� 4��'),('A�� 5��'),('A�� 6��'),('A�� 7��'),('A�� 8��'),
('B�� 1��'),('B�� 2��'),('B�� 3��'),('B�� 4��'),('B�� 5��'),('B�� 6��'),('B�� 7��'),('B�� 8��'),
('C�� 1��'),('C�� 2��'),('C�� 3��'),('C�� 4��'),('C�� 5��'),('C�� 6��'),('C�� 7��'),('C�� 8��'),
('D�� 1��'),('D�� 2��'),('D�� 3��'),('D�� 4��'),('D�� 5��'),('D�� 6��'),('D�� 7��'),('D�� 8��'),
('E�� 1��'),('E�� 2��'),('E�� 3��'),('E�� 4��'),('E�� 5��'),('E�� 6��'),('E�� 7��'),('E�� 8��'),
('F�� 1��'),('F�� 2��'),('F�� 3��'),('F�� 4��'),('F�� 5��'),('F�� 6��'),('F�� 7��'),('F�� 8��');


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
VALUES ('minchul', '1234', '�չ�ö', '���α׷� �������� ���','23',1), 
('uihyeon', '1234', '������', '��ȭ ������ ���','23',1),
('seungjun', '1234', '�ǽ���', '��ȭ ���� ���','23',1),
('taeil', '1234', '������', '���� ���','24',1);

CREATE TABLE cgv(
  cgv_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cgv_name VARCHAR(20) NOT NULL,
  cgv_address VARCHAR (30) NOT NULL
);

INSERT INTO cgv (cgv_name, cgv_address)
VALUES ('CGV����', '��󳲵� â���� ����ȸ���� 3��15��� 736'), ('CGVâ��', '��󳲵� â���� ��â�� â�����397���� 6'),
('CGVâ������Ƽ', '��󳲵� â���� ���̴�� 320'), ('CGVõ��', '��û���� õ�Ƚ� ������ ���� 47'),
('CGVõ����Ÿ��Ʈ', '��û���� õ�Ƚ� ���ϱ� ������ 196'), ('CGVõ���͹̳�', '��û���� õ�Ƚ� ������ ������ 43'),
('CGV����', '����Ư���� ������ ������� 438'), ('CGV�б���', '����Ư���� ������ �б�����30�� 45'),
('CGV��', '����Ư���� ��õ�� �񵿵��� 257'), ('CGV��������ũ��', '����Ư���� ��걸 �Ѱ����23�� 55'),
('CGV��', '����Ư���� �߱� ���� 14'), ('CGV������', '��⵵ ������ �ȴޱ� �Ǳ��� 181'),
('CGV�ϼ���', '��⵵ ������ ��ȱ� ������ 950'), ('CGV����', '��⵵ ������ �ȴޱ� ������� 924'),
('CGV���', '��õ������ ��籸 ������ 738'), ('CGV�־ȿ�', '��õ������ ����Ȧ�� ��â�� 58'),
('CGV��õ', '��õ������ ������ ������ 198'), ('CGV����', '��õ������ ���� ����� 489'),
('CGV�ϻ�', '��⵵ ���� �ϻ굿�� ���߻�� 24'), ('CGVȭ��', '��⵵ ���� ���籸 ȭ�߷� 104���� 28'),
('CGV������', '��⵵ �����ν� ��ȭ�� 525'), ('CGV����������', '��⵵ �����ν� �ùη� 80'),
('CGV ����', '��⵵ ���ý� ���÷� 51'), ('CGV���üһ�', '��⵵ ���ý� �򳲷� 862');


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




























