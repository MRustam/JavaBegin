--вывести сумарную выручку за январь 2014 года
SELECT
    SUM((SELECT price FROM Transport WHERE id = sold.transport_id)) AS Выручка
FROM Sold

WHERE strftime('%Y', selle_date) = '2014' AND strftime('%m', selle_date) = '01'