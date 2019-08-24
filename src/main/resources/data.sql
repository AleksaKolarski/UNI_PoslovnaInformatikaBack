INSERT INTO warehouse (name, address) VALUES ('Warehouse0', 'Narodnog fronta');

INSERT INTO fiscal_year (year, started_on) VALUES (2019, '2019-01-01');

INSERT INTO article_group (id, name) VALUES (1, 'cpu');
INSERT INTO article_group (id, name) VALUES (2, 'gpu');
INSERT INTO article_group (id, name) VALUES (3, 'motherboard');
INSERT INTO article_group (id, name) VALUES (4, 'cables');

INSERT INTO article (id, name, unit, article_group_id) VALUES (1, 'Intel i7 8th gen', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (2, 'GeForce 1080', 'PCS', 2);
INSERT INTO article (id, name, unit, article_group_id) VALUES (3, 'Intel Dual Core', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (4, 'AMD Ryzen 5', 'PCS', 1);
INSERT INTO article (id, name, unit, article_group_id) VALUES (5, 'AMD Board', 'PCS', 3);
INSERT INTO article (id, name, unit, article_group_id) VALUES (6, 'Ethernet UTP', 'm', 4);
INSERT INTO article (id, name, unit, article_group_id) VALUES (7, 'Optical', 'm', 4);

INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (1, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (2, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (3, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (4, 1, 1);
INSERT INTO article_card (article_id, fiscal_year_id, warehouse_id) VALUES (5, 1, 1);