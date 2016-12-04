WITH home_req AS (
  SELECT

      count(r) home_req_count
    FROM request r
      JOIN request h_r ON r.service_type = 'HOME'

)