INSERT INTO warehouse (name, address) VALUES ('Warehouse0', 'Narodnog fronta');

INSERT INTO fiscal_year (year, started_on) VALUES (2019, '2019-01-01');

INSERT INTO article_group (id, name) VALUES (1, 'cpu');
INSERT INTO article_group (id, name) VALUES (2, 'gpu');
INSERT INTO article_group (id, name) VALUES (3, 'motherboard');

INSERT INTO article (name, unit, article_group_id) VALUES ('Intel i7 8th gen', 'PCS', 1);
INSERT INTO article (name, unit, article_group_id) VALUES ('GeForce 1080', 'PCS', 2);
INSERT INTO article (name, unit, article_group_id) VALUES ('Intel Dual Core', 'PCS', 1);
INSERT INTO article (name, unit, article_group_id) VALUES ('AMD Ryzen 5', 'PCS', 1);
INSERT INTO article (name, unit, article_group_id) VALUES ('AMD Board', 'PCS', 3);


