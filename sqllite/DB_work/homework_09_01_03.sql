--‎Вывести общую выручку 2014 - 2017
SELECT 

    SUM(tr.price) AS profit
    
FROM Sold so
INNER JOIN Transport tr ON so.transport_id = tr.id

WHERE strftime('%Y', selle_date) BETWEEN '2014' AND '2017'
