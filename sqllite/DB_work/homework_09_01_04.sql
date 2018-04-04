--‎Вывести актуальные(проданные) цвета по убыванию(по колличеству проданных)
SELECT
    cl.name_en AS color,
    COUNT(cl.name_en) AS count
FROM Sold so
LEFT JOIN Transport tr ON so.transport_id = tr.id
INNER JOIN dir_color cl ON tr.color_id = cl.id

GROUP BY cl.name_en
