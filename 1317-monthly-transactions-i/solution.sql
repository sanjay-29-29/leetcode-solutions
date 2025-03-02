select 
    date_format(trans_date, '%Y-%m') as month,
    country, 
    count(*)  as trans_count,
    count(
        case when
        state = 'approved'
        then 1
        else null
        end
    ) as approved_count,
    sum(amount) as trans_total_amount,
    sum(
        case when 
        state = 'approved' 
        then amount 
        else 0 
        end
    ) as approved_total_amount
from Transactions
group by country, month(trans_date), year(trans_date);
