--Сгруппировать продавцов по году рождения(без месяца и дня),
--для каждого года вывести колличество людей

SELECT
    strftime('%Y', birthday) AS birthyear,
    COUNT(id) AS seller_id
FROM Seller
GROUP BY birthyear
