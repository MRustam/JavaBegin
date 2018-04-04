--‎Вывести непроданные авто с объемом двигателя больше 4.
SELECT 
    
    (SELECT name_en FROM dir_brend WHERE id = tr.brend_id) AS brend,
    (SELECT name_en FROM dir_model WHERE id = cr.model_id) AS model,
    (SELECT selle_date FROM Sold WHERE transport_id = tr.id)selle_date,
    cr.volume AS volume
    
FROM Car cr, Transport tr
WHERE cr.transport_id = tr.id AND cr.transport_id NOT IN (SELECT transport_id FROM Sold) AND cr.volume > 4