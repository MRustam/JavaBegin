--по каждому продавцу вывести колличество проданных авто
 SELECT 
 
     sel.fio,
     COUNT(sel.id) AS Продал_авто
     
 FROM Sold sol
 INNER JOIN Seller sel ON sol.seller_id = sel.id
 
 GROUP BY fio