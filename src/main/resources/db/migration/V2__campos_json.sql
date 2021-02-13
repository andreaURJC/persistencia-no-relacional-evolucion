/* Create new fields */
ALTER TABLE vuelo ADD tripulantes_json JSON NULL;
ALTER TABLE avion ADD revisiones_json JSON NULL;

/* Update fields */
UPDATE vuelo v
SET v.tripulantes_json = (
    SELECT JSON_ARRAYAGG(JSON_OBJECT('codigo_empleado',vt.tripulante_codigo_empleado))
    FROM vuelo_tripulante vt
    WHERE vt.vuelo_codigo_vuelo = v.codigo_vuelo);

UPDATE avion a
SET revisiones_json = (
    SELECT JSON_ARRAYAGG(JSON_OBJECT(
        'id',r.id,
        'descripcion', r.descripcion,
        'fecha_fin', r.fecha_fin,
        'fecha_inicio', r.fecha_inicio,
        'horas', r.horas,
        'tipo', r.tipo,
        'aeropuerto', r.aeropuerto,
        'mecanico', r.mecanico))
    FROM revision r
    WHERE r.avion = a.matricula);