--вывести всех продавцов которые продали авто обьемом свыше 3л.
SELECT
    *,
    (SELECT fio FROM Seller WHERE id = sold.seller_id) AS ФИО
FROM Sold

WHERE (SELECT volume FROM Car WHERE id = sold.transport_id) > 3.0

--вывести всех продавцов которые продали хотябы одно авто с электородвигателем 
/*SELECT
    *,
    (SELECT fio FROM Seller WHERE id = so.seller_id)
FROM Sold so

--WHERE (SELECT engine_type_id FROM Transport WHERE id = so.transport_id) = 4*/