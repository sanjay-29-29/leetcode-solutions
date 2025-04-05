# Write your MySQL query statement below
SELECT id, SUM(friends) as num FROM (
    (SELECT requester_id as id, COUNT(*) as friends
 from RequestAccepted
 group by requester_id)
 union all
(SELECT accepter_id as acc_id, COUNT(*) as friends
from RequestAccepted
group by accepter_id)
) as t
GROUP BY id 
ORDER BY num 
DESC LIMIT 1;
