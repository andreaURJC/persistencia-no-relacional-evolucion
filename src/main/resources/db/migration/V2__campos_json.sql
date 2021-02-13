/* Create new fields */
ALTER TABLE vuelo ADD tripulantes_json JSON NULL;
ALTER TABLE avion ADD revisiones_json JSON NULL;

/* Update fields */
UPDATE vuelo
SET tripulantes_json = (SELECT JSON_ARRAYAGG(JSON_OBJECT('codigo_empleado',tripulante_codigo_empleado))
from vuelo_tripulante where vuelo_codigo_vuelo = vuelo.codigo_vuelo);

UPDATE avion
SET revisiones_json = (SELECT JSON_ARRAYAGG(JSON_OBJECT('id',id,
'descripcion', descripcion,
'fecha_fin',fecha_fin,
'fecha_inicio', fecha_inicio,
'horas', horas,
'tipo', tipo,
'aeropuerto', aeropuerto,
'mecanico', mecanico)) FROM revision WHERE avion = avion.matricula);