--вывести сумарную выручку за январь 2014 года
SELECT
    SUM(tr.price) AS Выручка
FROM Sold
INNER JOIN Transport tr ON sold.transport_id = tr.id
WHERE strftime('%Y', selle_date) = '2014' AND strftime('%m', selle_date) = '01'