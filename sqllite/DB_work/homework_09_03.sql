--вывести все записи по всем авто но только для марки Порше и ценой > 50000 E
--Вывести все данные об авто
SELECT
    cr.transport_id AS id,
    
    (SELECT name_ru FROM dir_brend WHERE id = tr.brend_id) AS бренд,
    (SELECT name_ru FROM dir_model WHERE id = cr.model_id) AS модель,
    (SELECT name_ru FROM dir_country WHERE id = tr.country_id) AS страна,
    tr.issue_date AS дата,
    (SELECT name_ru FROM dir_color WHERE id = tr.color_id) AS цвет,
    (SELECT name_ru FROM dir_body_type WHERE id = cr.body_type_id) AS кузов,
    (SELECT name_ru FROM dir_engine_type WHERE id = tr.engine_type_id) AS двигатель,
    cr.volume AS обьем,
    cr.power AS мощьность,
    (SELECT name_ru FROM dir_drive_type WHERE id = cr.drive_type_id) AS привод,
    (SELECT name_ru FROM dir_transmission_type WHERE id = cr.transmission_type_id) AS коробка,
    tr.price AS цена,
    (SELECT name_ru FROM dir_currency WHERE id = tr.currency_id) AS валюта
    
FROM Transport tr, Car cr

WHERE cr.transport_id = tr.id AND tr.brend_id = 6 AND tr.price > 50000