INSERT INTO warehouse (name, address) VALUES ('Glavni magacin', 'Narodnog fronta 59');
INSERT INTO warehouse (name, address) VALUES ('Mali magacin', 'Novosadkog sajma');
INSERT INTO warehouse (name, address) VALUES ('Veliki magacin', 'Spens');

INSERT INTO fiscal_year (year, started_on) VALUES (2019, '2019-01-01');

INSERT INTO article_group (id, name) VALUES (1, 'cpu');
INSERT INTO article_group (id, name) VALUES (2, 'gpu');
INSERT INTO article_group (id, name) VALUES (3, 'motherboard');
INSERT INTO article_group (id, name) VALUES (4, 'cables');

INSERT INTO business_partner (id, name, pib, address, city) VALUES (1, 'Global Computers DOO', '123456789', 'Adresa 12 Kaplara', 'Novi Sad');
INSERT INTO business_partner (id, name, pib, address, city) VALUES (2, 'Gigatron', '234567890', 'Novog Stadiona 69', 'Novi Sad');
INSERT INTO business_partner (id, name, pib, address, city) VALUES (3, 'Win Win', '345678901', 'Novog Boga 21', 'Beograd');
INSERT INTO business_partner (id, name, pib, address, city) VALUES (4, 'Srpski kompjuter', '3456789012', '12 Kaplara', 'Beograd');

INSERT INTO article (id, name, unit, article_group_id) VALUES (1, 'Intel i7 8th gen', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (2, 'GeForce 1080', 'PCS', 2);
INSERT INTO article (id, name, unit, article_group_id) VALUES (3, 'Intel Dual Core', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (4, 'AMD Ryzen 5', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (5, 'AMD Board', 'PCS', 3);
INSERT INTO article (id, name, unit, article_group_id) VALUES (6, 'Ethernet UTP', 'm', 4);
INSERT INTO article (id, name, unit, article_group_id) VALUES (7, 'Optical', 'm', 4);
INSERT INTO article (id, name, unit, article_group_id) VALUES (8, 'Intel i5 8th gen', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (9, 'AMD Ryzen 3', 'PCS', 1);

INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (1, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (2, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (3, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (4, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (5, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (6, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (7, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (8, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (9, 1, 1);

INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (1, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (2, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (3, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (4, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (5, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (6, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (7, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (8, 1, 2);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (9, 1, 2);

INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (1, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (2, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (3, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (4, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (5, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (6, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (7, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (8, 1, 3);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (9, 1, 3);