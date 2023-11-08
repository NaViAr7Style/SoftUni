INSERT INTO users (id, is_active, email, first_name, last_name, password)
VALUES
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', '22fb398fcbc2ec10083f18f1c72995794f820b00616735792a5b91f2675d7001ddc67c5111375eaeab99636a5a324cf0'),
    (2, 1, 'user@example.com', 'User', 'Userov', '22fb398fcbc2ec10083f18f1c72995794f820b00616735792a5b91f2675d7001ddc67c5111375eaeab99636a5a324cf0');

INSERT INTO roles (id, role)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);

INSERT INTO brands (id, name)
VALUES
    (1, 'Toyota'),
    (2, 'Ford'),
    (3, 'Trabant');

INSERT INTO models (id, category, brand_id, name)
VALUES
    (1, 'CAR', 1, 'Camry'),
    (2, 'CAR', 1, 'Corolla'),
    (3, 'CAR', 2, 'Focus'),
    (4, 'CAR', 2, 'Fiesta'),
    (5, 'CAR', 3, '601');

INSERT INTO offers(id, description, engine, image_url, mileage, price, transmission, uuid, year, model_id)
VALUES
    (1, 'Top Trabi! 1', 'Petrol', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 250001, 2001, 'Manual', 'be554e31-4029-4397-91c3-dc2281441c51', 1981, 5),
    (2, 'Top Trabi! 2', 'Petrol', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 250002, 2002, 'Manual', 'be554e31-4029-4397-91c3-dc2281441c52', 1982, 5),
    (3, 'Top Trabi! 3', 'Petrol', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 250003, 2003, 'Manual', 'be554e31-4029-4397-91c3-dc2281441c53', 1983, 5),
    (4, 'Top Trabi! 4', 'Petrol', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 250004, 2004, 'Manual', 'be554e31-4029-4397-91c3-dc2281441c54', 1984, 5),
    (5, 'Top Trabi! 5', 'Petrol', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 250005, 2005, 'Manual', 'be554e31-4029-4397-91c3-dc2281441c55', 1985, 5);