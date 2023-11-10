CREATE TABLE sensors (
    id SERIAL PRIMARY KEY,
    sensor_type_id INTEGER REFERENCES sensor_types(id),
    is_enabled BOOLEAN NOT NULL,
    installation_date DATE NOT NULL
);