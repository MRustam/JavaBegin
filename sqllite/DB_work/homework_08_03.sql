--вывести все записи по всем авто но только для марки Порше и ценой > 50000 E
--Вывести все данные об авто
SELECT
    cr.transport_id AS id,
    
    br.name_ru AS бренд,
    md.name_ru AS модель,
    co.name_ru AS страна,
    tr.issue_date AS date,
    cl.name_ru AS color,
    bt.name_ru AS кузов,
    et.name_ru AS двигатель,
    cr.volume AS обьем,
    cr.power AS мощьность,
    dt.name_ru AS привод,
    tt.name_ru AS коробка,
    tr.price AS цена,
    cu.name_ru AS валюта
FROM Transport tr, Car cr
INNER JOIN dir_country co ON tr.country_id = co.id
INNER JOIN dir_brend br ON tr.brend_id = br.id
INNER JOIN dir_color cl ON tr.color_id = cl.id
INNER JOIN dir_model md ON cr.model_id = md.id
INNER JOIN dir_body_type bt ON cr.body_type_id = bt.id
INNER JOIN dir_engine_type et ON tr.engine_type_id = et.id
INNER JOIN dir_drive_type dt ON cr.drive_type_id = dt.id
INNER JOIN dir_transmission_type tt ON cr.transmission_type_id = tt.id
INNER JOIN dir_currency cu ON tr.currency_id = cu.id

WHERE cr.transport_id = tr.id  AND br.name_ru = 'Порше' AND tr.price > 50000
