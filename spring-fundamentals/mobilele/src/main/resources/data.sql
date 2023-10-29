INSERT INTO users (id, is_active, email, first_name, last_name, password)
VALUES
    (1, 1, 'k.deliev@abv.bg', 'Kani', 'Deliev', '22fb398fcbc2ec10083f18f1c72995794f820b00616735792a5b91f2675d7001ddc67c5111375eaeab99636a5a324cf0');

INSERT INTO brands (id, name)
VALUES
    (1, 'Toyota'),
    (2, 'Ford');

INSERT INTO models (id, category, brand_id, name)
VALUES
    (1, 'CAR', 1, 'Camry'),
    (2, 'CAR', 1, 'Corolla'),
    (3, 'CAR', 2, 'Focus'),
    (4, 'CAR', 2, 'Fiesta');