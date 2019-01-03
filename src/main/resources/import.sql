INSERT INTO city (name) VALUES ('Novi Sad');
INSERT INTO city (name) VALUES ('Crvenka');
INSERT INTO city (name) VALUES ('Beograd');

INSERT INTO company (pib, address, name, city) VALUES ('514256987', 'Zrtava racije 12', 'Tim Raketa', 1);

INSERT INTO role (name) VALUES ('Admin');
INSERT INTO role (name) VALUES ('Magacioner');

INSERT INTO warehouse (name, address, company_id) VALUES ('Skladiste 1 SEVER', 'Industrijska Zona Sever 21', 1);
INSERT INTO warehouse (name, address, company_id) VALUES ('Skladiste 2 JUG', 'Industrijska Zona Jug 420', 1);

INSERT INTO employee (first_name, last_name, email, password, company, role, warehouse) 
	VALUES ('Milan', 'Miljus', 'milan@milan.com', '123', 1, 1, 1);
INSERT INTO employee (first_name, last_name, email, password, company, role, warehouse) 
	VALUES ('Marko', 'Krizan', 'markela@marko.com', '123', 1, 1, 2);
	
INSERT INTO article_group (name, company_id) VALUES ('Kancelarijski pribor', 1);
INSERT INTO article_group (name, company_id) VALUES ('Stocna hrana', 1);

INSERT INTO unit (name) VALUES ('komad');
INSERT INTO unit (name) VALUES ('kg');
INSERT INTO unit (name) VALUES ('dcl');

INSERT INTO article (name, article_group_id, unit_id) VALUES ('Olovka', 1, 1);
INSERT INTO article (name, article_group_id, unit_id) VALUES ('Plastelin', 1, 2);
INSERT INTO article (name, article_group_id, unit_id) VALUES ('Tempera', 1, 3);
INSERT INTO article (name, article_group_id, unit_id) VALUES ('Najbolja hrana za svilje', 2, 2);

INSERT INTO fiscal_year (concluded, started_on, ended_on, year, company_id) VALUES (true, '2017-01-01', '2018-01-20', 2017, 1);
INSERT INTO fiscal_year (concluded, started_on, ended_on, year, company_id) VALUES (false, '2018-01-21', null, 2018, 1);











	
INSERT INTO business_partner (name, pib, address, city_id, company_id) VALUES ('Partner 1', '231231', 'Zelenih 200', 1, 1);
	
INSERT INTO document (formed_on, booked_on, serial_number, status, type, fiscal_year_id, mandatory_warehouse_id, business_partner_id, warehouse_id) 
	VALUES (NOW(), NOW(), 123, 'x', 'x', 1, 1, 1, null);
INSERT INTO document (formed_on, booked_on, serial_number, status, type, fiscal_year_id, mandatory_warehouse_id, business_partner_id, warehouse_id) 
	VALUES (NOW(), NOW(), 124, 'x', 'x', 1, 1, null, 2);
	
INSERT INTO document_item (price, quantity, value, article_id, document_id) VALUES (120, 2, 240, 2, 1);
INSERT INTO document_item (price, quantity, value, article_id, document_id) VALUES (250, 1, 250, 3, 1);

INSERT INTO document_item (price, quantity, value, article_id, document_id) VALUES (120, 3, 360, 1, 2);
INSERT INTO document_item (price, quantity, value, article_id, document_id) VALUES (250, 1, 250, 2, 2);
INSERT INTO document_item (price, quantity, value, article_id, document_id) VALUES (1000, 1, 1000, 4, 2);

INSERT INTO article_card (price,
						start_state_quantity, start_state_value,
						in_quantity, in_value,
						out_quantity, out_value,
						sum_quantity, sum_value,
						article_id, fiscal_year_id, warehouse_id) 
			VALUES     (120,
						1000, 1000,
						15, 15,
						10, 10,
						1005, 1005,
						1, 1, 1);
						
INSERT INTO article_card_analytics (price, quantity, value, direction, serial_number, type, article_card_id)
	VALUES (120, 10, 1200, 'x', 131231, 'x', 1);
INSERT INTO article_card_analytics (price, quantity, value, direction, serial_number, type, article_card_id)
	VALUES (120, 10, 1200, 'x', 131232, 'x', 1);
INSERT INTO article_card_analytics (price, quantity, value, direction, serial_number, type, article_card_id)
	VALUES (120, 10, 1200, 'x', 131233, 'x', 1);



