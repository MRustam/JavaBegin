--по каждому продавцу вывести колличество проданных авто
 SELECT 
     se.id,
     se.fio,
     (SELECT COUNT(id) FROM Sold WHERE se.id = sold.seller_id) AS Продал
 FROM Seller se
 WHERE Продал > 0
 GROUP BY se.fio