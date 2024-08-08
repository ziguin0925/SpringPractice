SELECT * FROM web_ex.product;
insert into brand(brand_id, name, img, product_num)
	values
		('A00000000001', 'GUCCI', '/img/GUCCI/brand/img1',50),
		('A00000000002', 'NIKE', '/img/NIKE/brand/img1',120),
		('A00000000003', 'ADIDAS', '/img/ADIDAS/brand/img1',361),
		('A00000000004', 'MNC', '/img/MNC/brand/img1',28)
;
insert into product_description(product_description_id, description, modify_datetime)
	values
		('NIKE000000001', '나이키의 반팔 티는 좋은 제품이다.', '2019-05-22'),
        ('GUCCI00000001', '구찌의 아동 복은 좋은 제품이다.', '2024-03-11'),
		('GUCCI00000002', '구찌의 여성 블라우스는 좋은 제품이다.', '2024-01-03'),
		('MNC0000000003', 'MNC의 모자는 좋은 제품이다.', '2023-09-24'),
		('ADIDAS0000005', '아디다스의 아동복은 좋은 제품이다.', '2011-11-24'),
        ('NIKE000000002', '나이키의 여성 스커트는 좋은 제품이다.', '2021-05-12'),
        ('ADIDAS0000001', '아디다스의 여성 블라우스는 좋은 제품이다.', '2011-10-24')
;


INSERT INTO category (category_id, category_name, parent_category_id) 
	VALUES
		-- Existing categories
		('C01', '의류', NULL),
        ('C02', '남성 의류', 'C01'),
		('C03', '여성 의류', 'C01'),
		('C04', '아동 의류', 'C01'),
        ('C05', '남성 상의', 'C02'),
		('C06', '남성 하의', 'C02'),
		('C07', '남성 아우터', 'C02'),
        ('C08', '여성 상의', 'C03'),
		('C09', '여성 하의', 'C03'),
		('C10', '여성 아우터', 'C03'),
        ('C11', '아동 상의', 'C04'),
		('C12', '아동 하의', 'C04'),
		('C13', '아동 아우터', 'C04'),

		-- New categories
		-- 남성 의류 세부 카테고리
		('C14', '남성 액세서리', 'C02'),
		('C15', '남성 신발', 'C02'),
		('C16', '남성 스포츠 의류', 'C02'),
		-- 남성 상의 세부 카테고리
		('C17', '남성 티셔츠', 'C05'),
		('C18', '남성 셔츠', 'C05'),
		('C19', '남성 스웨터', 'C05'),
		('C20', '남성 조끼', 'C05'),
		-- 남성 하의 세부 카테고리
		('C21', '남성 청바지', 'C06'),
		('C22', '남성 반바지', 'C06'),
		('C23', '남성 슬랙스', 'C06'),
		-- 남성 아우터 세부 카테고리
		('C24', '남성 자켓', 'C07'),
		('C25', '남성 코트', 'C07'),
		('C26', '남성 패딩', 'C07'),
		-- 여성 의류 세부 카테고리
		('C27', '여성 액세서리', 'C03'),
		('C28', '여성 신발', 'C03'),
		('C29', '여성 스포츠 의류', 'C03'),
		-- 여성 상의 세부 카테고리
		('C30', '여성 블라우스', 'C08'),
		('C31', '여성 티셔츠', 'C08'),
		('C32', '여성 스웨터', 'C08'),
		('C33', '여성 카디건', 'C08'),
		-- 여성 하의 세부 카테고리
		('C34', '여성 스커트', 'C09'),
		('C35', '여성 청바지', 'C09'),
		('C36', '여성 슬랙스', 'C09'),
		-- 여성 아우터 세부 카테고리
		('C37', '여성 자켓', 'C10'),
		('C38', '여성 코트', 'C10'),
		('C39', '여성 패딩', 'C10'),
		-- 아동 의류 세부 카테고리
		('C40', '아동 액세서리', 'C04'),
		('C41', '아동 신발', 'C04'),
		('C42', '아동 스포츠 의류', 'C04'),
		-- 아동 상의 세부 카테고리
		('C43', '아동 티셔츠', 'C11'),
		('C44', '아동 셔츠', 'C11'),
		('C45', '아동 스웨터', 'C11'),
		-- 아동 하의 세부 카테고리
		('C46', '아동 청바지', 'C12'),
		('C47', '아동 반바지', 'C12'),
		('C48', '아동 레깅스', 'C12'),
		-- 아동 아우터 세부 카테고리
		('C49', '아동 자켓', 'C13'),
		('C50', '아동 코트', 'C13'),
		('C51', '아동 패딩', 'C13')
;
INSERT INTO product (
    product_id,
    product_description_id,
    category_id,
    brand_id,
    name,
    rep_img,
    price,
    is_displayed,
    create_datetime,
    modify_datetime,
    sales_quantity,
    register_manager,
    star_rating,
    view_count,
    review_count
) VALUES
	('P001', 'NIKE000000001', 'C05', 'A00000000002', '나이키 남성 빨강 티셔츠', '/img/NIKE/rep/image1.jpg', 29900, 'Y', '2021-08-05 12:00:00', NOW(), 120, 'manager1', 4.5, 0, 0),
    ('P002', 'GUCCI00000002', 'C08', 'A00000000001', '구찌 여성 스몰 사이즈 블라우스', '/img/GUCCI/rep/image1.jpg', 248900, 'Y', '2022-08-01 07:30:00', NOW(), 55550, 'manager2', 4.8, 0, 0),
    ('P003', 'ADIDAS0000005', 'C11', 'A00000000003', '아디다스 아동 티셔츠 1', '/img/ADIDAS/rep/image1.jpg', 58900, 'Y', '2012-07-15 11:30:00', NOW(), 28839, 'manager3', 4.9, 0, 0),
    ('P004', 'ADIDAS0000005', 'C11', 'A00000000003', '아디다스 아동 티셔츠 2', '/img/ADIDAS/rep/image2.jpg', 58900, 'Y', '2021-01-09 11:30:00', NOW(), 1267, 'manager3', 4.0, 0, 0),
    ('P005', 'MNC0000000003', 'C06', 'A00000000004', 'MNC 남성 청바지', '/img/MNC/rep/image1.jpg', 19900, 'Y', '2023-11-09 22:21:19', NOW(), 15425, 'manager4', 3.9, 0, 0),
    ('P006', 'NIKE000000002', 'C09', 'A00000000002', '나이키 여성 스커트', '/img/NIKE/rep/image2.jpg', 15260, 'Y', '2024-02-01 09:41:12', NOW(), 67890, 'manager5', 4.0, 0, 0),
    ('P007', 'GUCCI00000001', 'C13', 'A00000000001', '구찌 아동 아우터 특가 상품', '/img/GUCCI/rep/image2.jpg', 78900, 'Y', '2024-03-11 19:01:10', NOW(), 1403, 'manager2', 4.1, 0, 0),
    ('P008', 'NIKE000000002', 'C08', 'A00000000002', '나이키 여성 블라우스 특가 상품', '/img/NIKE/rep/image3.jpg', 89000, 'Y', '2023-12-01 10:34:19', NOW(), 5123, 'manager1', 4.3, 0, 0)
;
        
INSERT INTO stock(product_id, size, color, quantity, create_datetime)
	VALUES
		('P001','L','R', 123,NOW()),
        ('P001','XL','R', 42,NOW()),
        ('P001','M','R',13 ,NOW()),
        ('P002','S','Blue',451 ,NOW()),
        ('P002','S','Red',111 ,NOW()),
        ('P002','S','Gray',200 ,NOW()),
        ('P002','S','Green',345 ,NOW()),
        ('P002','S','Black',512 ,NOW()),
        ('P003','M','Blue',451 ,NOW()),
        ('P003','L','Blue',43 ,NOW()),
        ('P003','XL','Blue',45 ,NOW()),
		('P003','XXL','Blue',41 ,NOW()),
		('P003','M','Green',1452 ,NOW()),
        ('P003','L','Green',34 ,NOW()),
        ('P003','XL','Green',2 ,NOW()),
		('P003','XXL','Green',411 ,NOW()),
        ('P004','L','Gray',2 ,NOW()),
        ('P005','28','blue',123 ,NOW()),
        ('P005','30','blue',142 ,NOW()),
        ('P005','32','blue',231 ,NOW()),
        ('P005','34','blue',23 ,NOW()),
        ('P005','36','blue',12 ,NOW()),
        ('P006','24','White',250 ,NOW()),
        ('P006','26','White',123 ,NOW()),
        ('P006','28','White',244 ,NOW()),
        ('P006','30','White',119 ,NOW()),
        ('P007','XL','black',189 ,NOW()),
        ('P007','L','black',123 ,NOW()),
        ('P007','M','black',111 ,NOW()),
        ('P007','S','black',321 ,NOW()),
        ('P008','24','blue',32 ,NOW()),
        ('P008','26','blue',45 ,NOW()),
        ('P008','28','blue',67 ,NOW()),
        ('P008','30','blue',213 ,NOW())
;

INSERT INTO product_description_img (
    product_description_id,
    name,
    order_num,
    path,
    is_used,
    kind_of,
    size,
    create_datetime,
    modify_datetime
) VALUES

('NIKE000000001', '반팔 티image_D1', 1, '/img/NIKE/image1.jpg','Y' , 'd', 1024, NOW(), NOW()),
('NIKE000000001', 'aaaimage_D2', 2, '/img/NIKE/image2.jpg', 'Y', 'd', 1024, NOW(), NOW()),
('NIKE000000001', 'aaaimage_R1', 1, '/img/NIKE/image3.jpg', 'Y', 'r', 2048, NOW(), NOW()),
('NIKE000000001', 'aaaimage_R2', 2, '/img/NIKE/image4.jpg', 'Y', 'r', 2048, NOW(), NOW()),


('GUCCI00000001', '아동복 image_D1', 1, '/img/GUCCI/image1.jpg', 'Y', 'd', 1024, NOW(), NOW()),
('GUCCI00000001', '아동복 image_D2', 1, '/img/GUCCI/image2.jpg', 'Y', 'd', 1024, NOW(), NOW()),
('GUCCI00000001', '아동복 image_R1', 1, '/img/GUCCI/image3.jpg', 'Y', 'r', 1024, NOW(), NOW()),


('GUCCI00000002', '블라우스 image_R1', 1, '/img/GUCCI/image1.jpg', 'N', 'r', 2048, NOW(), NOW()),
('GUCCI00000002', '블라우스 image_R2', 2, '/img/GUCCI/image2.jpg', 'Y', 'r', 1024, NOW(), NOW()),
('GUCCI00000002', '블라우스 image_D1', 1, '/img/GUCCI/image4.jpg', 'Y', 'd', 2048, NOW(), NOW()),
('GUCCI00000002', '블라우스 image_D2', 2, '/img/GUCCI/image3.jpg', 'Y', 'd', 512, NOW(), NOW()),


('MNC0000000003', '청바지 image_D1', 2, '/img/MNC/image1.jpg', 'Y', 'd', 512, NOW(), NOW()),
('MNC0000000003', '청바지 image_D2', 1, '/img/MNC/image3.jpg', 'Y', 'd', 1024, NOW(), NOW()),
('MNC0000000003', '청바지 image_R1', 1, '/img/MNC/image2.jpg', 'Y', 'd', 1024, NOW(), NOW()),

('ADIDAS0000005', 'adidas_image_R1', 2, '/img/ADIDAS/image1.jpg', 'Y', 'r', 1024, NOW(), NOW()),
('ADIDAS0000005', 'adidas_image_R2', 1, '/img/ADIDAS/image2.jpg', 'Y', 'r', 1024, NOW(), NOW()),
('ADIDAS0000005', 'adidas_image_D1', 1, '/img/ADIDAS/image288.jpg', 'Y', 'd', 1024, NOW(), NOW()),
('ADIDAS0000005', 'adidas_image_D2', 3, '/img/ADIDAS/image284.jpg', 'Y', 'd', 1024, NOW(), NOW()),
('ADIDAS0000005', 'adidas_image_D3', 2, '/img/ADIDAS/image215.jpg', 'Y', 'd', 1024, NOW(), NOW()),

('NIKE000000002', 'nike_블라우스_image_r1', 2, '/img/NIKE/image213.jpg', 'Y', 'd', 1024, NOW(), NOW())
;

