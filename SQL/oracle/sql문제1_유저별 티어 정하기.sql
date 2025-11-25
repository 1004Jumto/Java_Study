select
    id,
    case
        when distance >= 130000 then 'DIAMOND'
        when distance >= 100000 then 'GOLD'
        when distance >= 50000 then 'SILVER'
        else 'BRONZE'
    end as tier
from game_users
order by id desc;
