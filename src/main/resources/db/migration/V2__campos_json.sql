ALTER TABLE vuelo ADD tripulantes_json JSON NULL;

ALTER TABLE avion ADD revisiones_json JSON NULL;

UPDATE vuelo SET tripulantes_json = '[{"codigo_empleado":"3"}]' WHERE codigo_vuelo = 100;
UPDATE vuelo SET tripulantes_json = '[{"codigo_empleado":"4"}]' WHERE codigo_vuelo = 200;

ALTER TABLE vuelo MODIFY COLUMN tripulantes_json JSON NOT NULL;