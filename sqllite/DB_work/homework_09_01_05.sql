--‎Кто продал самый дешевый седан.
SELECT
    (SELECT fio FROM Seller WHERE id = so.seller_id) AS ФИО,
    (SELECT name_en FROM dir_body_type WHERE id = cr.body_type_id) AS body,
    MIN(tr.price) AS price
FROM Sold so
INNER JOIN Transport tr ON so.transport_id = tr.id
INNER JOIN Car cr ON tr.id = cr.transport_id