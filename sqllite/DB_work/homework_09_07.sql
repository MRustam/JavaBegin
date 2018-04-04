/*--вывести всех продацов которые не продали ни одного авто
SELECT
     fio AS ФИО,
     birthday AS День_рождения,
     experiance AS стаж
FROM Seller se
LEFT JOIN Sold so ON se.id = so.seller_id
WHERE selle_date IS NULL

--ORDER BY fio*/

--вывести всех продацов которые не продали ни одного авто
SELECT
    *
FROM Seller
WHERE id NOT IN (SELECT seller_id FROM Sold)