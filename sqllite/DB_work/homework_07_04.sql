--Вывести возраст всех продавцов до сегодняшнего дня
SELECT
    birthday,
    fio,
    strftime('%Y', 'now') - strftime('%Y', birthday) AS Age
FROM Seller 