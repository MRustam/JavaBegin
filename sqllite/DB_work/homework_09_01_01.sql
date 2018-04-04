--Вывести среднюю выручку за все всё время по каждому продавцу, упорядочить по стажу, выручке.
SELECT 
    (SELECT fio FROM Seller WHERE id = so.seller_id) AS ФИО,
    AVG(tr.price) AS средняя_выручка,
    (SELECT experiance FROM Seller WHERE id = so.seller_id) AS стаж
FROM Sold so
INNER JOIN Transport tr ON so.transport_id
WHERE so.transport_id = tr.id
GROUP BY seller_id
