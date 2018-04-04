--получить по каждому продавцу колличество проданных им авто марки Мазератти
SELECT
    *,
    (SELECT fio FROM Seller WHERE id = sold.seller_id) ФИО,
    COUNT(transport_id) AS продал
FROM Sold

WHERE transport_id = (SELECT id FROM Transport WHERE brend_id = 5)
