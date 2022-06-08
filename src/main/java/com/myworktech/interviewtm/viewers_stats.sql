-- using FETCH NEXT
SELECT region, COUNT(*)
FROM viewers_stats v
GROUP BY region
    FETCH NEXT 5 ROW ONLY;

-- using row_number() if an old rdbms
SELECT t2.region, t2.cnt
FROM (SELECT t.region, t.cnt, ROW_NUMBER() OVER (ORDER BY cnt DESC) AS rank
      FROM (SELECT region, COUNT(*) AS cnt
            FROM viewers_stats v
            GROUP BY region) t) t2
WHERE rank <= 5

-- also, can add indexes on region and/or account_id
