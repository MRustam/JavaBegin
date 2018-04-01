/*--вывести всех продавцов которые продали авто обьемом свыше 3л.
SELECT
     fio AS ФИО,
     birthday AS День_рождения,
     experiance AS стаж
FROM Seller se
LEFT JOIN Sold so ON se.id = so.seller_id
INNER JOIN Transport tr ON so.transport_id = tr.id
INNER JOIN Car cr ON tr.id = cr.id
WHERE selle_date IS NOT NULL AND cr.volume > 3*/

--вывести всех продавцов которые продали хотябы одно авто с электородвигателем 
SELECT
    se.fio AS продавец,
    se.birthday AS день_рождения,
    br.name_ru AS бренд,
    et.name_ru AS тип_двигателя
FROM Sold co
INNER JOIN Transport tr ON co.transport_id = tr.id
INNER JOIN dir_brend br ON tr.brend_id = br.id
INNER JOIN Seller se ON co.seller_id = se.id
INNER JOIN dir_engine_type et ON tr.engine_type_id = et.id

WHERE engine_type_id = 4