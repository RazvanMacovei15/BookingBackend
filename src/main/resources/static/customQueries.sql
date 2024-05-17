SELECT
    CASE
        WHEN COUNT(*) > 0 THEN 0  -- Room is not available
        ELSE 1  -- Room is available
        END AS IsRoomAvailable
FROM ROOMS r
         LEFT JOIN RESERVATIONS b ON r.ID= b.ROOM_ID
WHERE
    (b.START_DATE>= @StartDate AND b.START_DATE< @EndDate)
    OR (b.END_DATE> @StartDate AND b.END_DATE<= @EndDate);