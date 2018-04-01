--получить по каждому продавцу колличество проданных им авто марки Мазератти
SELECT
    se.fio AS продавец,
    se.birthday AS день_рождения,
    br.name_ru AS бренд,
    COUNT(brend_id) AS колличество_шт
FROM Sold co
INNER JOIN Transport tr ON co.transport_id = tr.id
INNER JOIN dir_brend br ON tr.brend_id = br.id
INNER JOIN Seller se ON co.seller_id = se.id

WHERE br.name_ru = 'Мазератти'

GROUP BY brend_id


